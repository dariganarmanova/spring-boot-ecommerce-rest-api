package com.example.project.product;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @PreAuthorize("hasRolder('ADMIN')")
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.ok("Entity was created");
    }
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProduct() {
        return ResponseEntity.ok(productService.renderProducts());
    }
}
