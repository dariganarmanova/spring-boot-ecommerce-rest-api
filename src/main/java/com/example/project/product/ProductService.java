package com.example.project.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> renderProducts() {
        return productRepository.findAll();
    }
}
