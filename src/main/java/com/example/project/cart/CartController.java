package com.example.project.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @PostMapping("/cart/{id}")
    public ResponseEntity<?> createCart(@PathVariable Long id, @RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = cartService.createCart(id, cartRequest);
        return ResponseEntity.ok(cartResponse);
    }
}
