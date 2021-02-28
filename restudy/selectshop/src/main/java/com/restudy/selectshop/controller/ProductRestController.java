package com.restudy.selectshop.controller;

import com.restudy.selectshop.domain.Product;
import com.restudy.selectshop.domain.ProductMypriceRequestDto;
import com.restudy.selectshop.domain.ProductRepository;
import com.restudy.selectshop.domain.ProductRequestDto;
import com.restudy.selectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product setProduct(@RequestBody ProductRequestDto productRequestDto){
        Product product = new Product(productRequestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto productMypriceRequestDto){
        productService.update(id, productMypriceRequestDto);
        return id;
    }
}
