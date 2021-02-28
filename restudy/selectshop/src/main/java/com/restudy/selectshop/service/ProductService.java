package com.restudy.selectshop.service;

import com.restudy.selectshop.domain.Product;
import com.restudy.selectshop.domain.ProductMypriceRequestDto;
import com.restudy.selectshop.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        product.update(productMypriceRequestDto);
        return product.getId();
    }

}
