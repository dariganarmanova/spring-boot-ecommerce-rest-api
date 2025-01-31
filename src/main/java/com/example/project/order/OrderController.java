package com.example.project.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/createOrder/{id}")
    public ResponseEntity<?> createProduct(
        @PathVariable Long id, @RequestBody OrderRequest orderRequest
    ) {
        OrderResponse orderResponse = orderService.createOrder(id, orderRequest);
        return ResponseEntity.ok(orderResponse);
    }

}
