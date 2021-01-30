package com.sparta.week04.service;

import com.sparta.week04.domain.ItemDto;
import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductMypriceRequestDto;
import com.sparta.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto productMypriceRequestDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        product.update(productMypriceRequestDto);
        return id;
    }

    @Transactional
    public Long updateBySearch(Long id, ItemDto itemDto){
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }


}
