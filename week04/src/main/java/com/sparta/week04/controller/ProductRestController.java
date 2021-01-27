package com.sparta.week04.controller;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductRepository;
import com.sparta.week04.domain.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = new Product(productRequestDto);
        return productRepository.save(product);
    }
}
