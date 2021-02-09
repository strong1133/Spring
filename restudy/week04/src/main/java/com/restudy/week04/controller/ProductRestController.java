package com.restudy.week04.controller;

import com.restudy.week04.domain.ProdcutRequestDto;
import com.restudy.week04.domain.Product;
import com.restudy.week04.domain.ProductMypriceRequestDto;
import com.restudy.week04.domain.ProductRepository;
import com.restudy.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProdcutRequestDto prodcutRequestDto) {
        Product product = new Product(prodcutRequestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto) {
        return productService.update(id, productMypriceRequestDto);
    }

    @DeleteMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return id;
    }
}
