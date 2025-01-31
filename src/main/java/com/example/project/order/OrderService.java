package com.example.project.order;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.project.cart.Cart;
import com.example.project.cart.CartRepository;
import com.example.project.product.Product;
import com.example.project.product.ProductRepository;
import com.example.project.user.User;
import com.example.project.user.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    public Integer getCurrentUserId() {
        UserDetails userDetails = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String username = userDetails.getUsername();
        User currentUser = userRepository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return currentUser.getId();
    }
    @Transactional
    public OrderResponse createOrder(Long cartId, OrderRequest orderRequest) {
        Cart cart = cartRepository.findById(cartId)
            .orElseThrow(() -> new RuntimeException("cart cannot be found"));
        Product product = productRepository.findById(cart.getProduct().getId())
            .orElseThrow(() -> new RuntimeException("product cannot be found"));
        Long price = product.getPrice() * orderRequest.getQuantity();
        User user = userRepository.findById(getCurrentUserId())
            .orElseThrow(() -> new RuntimeException("user cannot be found"));
        Order order = new Order();
        order.setCart(cart);
        order.setUser(user);
        order.setQuantity(orderRequest.getQuantity());
        Order savedOrder = orderRepository.save(order);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setName(savedOrder.getCart().getProduct().getName());
        orderResponse.setQuantity(savedOrder.getQuantity());
        orderResponse.setUser_id(savedOrder.getUser().getId());
        orderResponse.setUsername(savedOrder.getUser().getUsername());
        orderResponse.setPrice(price);
        return orderResponse;
    }
}
