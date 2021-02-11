package com.restudy.week04.service;

import com.restudy.week04.domain.Product;
import com.restudy.week04.domain.ProductMypriceRequestDto;
import com.restudy.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 하는 아이디가 없습니다. ")
        );
        product.update(productMypriceRequestDto);
        return product.getId();
    }
}

