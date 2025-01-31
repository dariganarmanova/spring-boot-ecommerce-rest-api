package com.example.project.cart;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.project.product.Product;
import com.example.project.product.ProductRepository;
import com.example.project.user.User;
import com.example.project.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Integer getCurrentUserId() {
        UserDetails userDetails = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String username = userDetails.getUsername();
        User currentUser = userRepository.findByEmail(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return currentUser.getId();
    }

    public CartResponse createCart(Long productId, CartRequest cartRequest) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product was not found"));
        User user = userRepository.findById(getCurrentUserId())
            .orElseThrow(() -> new RuntimeException("The user was not found"));
        Cart cart = new Cart();
        Integer quantity = cartRequest.getQuantity();
        Long price = product.getPrice() * quantity;
        cart.setProduct(product);
        cart.setUser(user);
        cart.setPrice(price);
        cart.setQuantity(quantity);
        Cart savedCart = cartRepository.save(cart);
        CartResponse cartResponse = new CartResponse();
        cartResponse.setPrice(savedCart.getPrice());
        cartResponse.setQuantity(savedCart.getQuantity());
        return cartResponse;
    }
}
