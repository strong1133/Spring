package com.sparta.week04.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto productRequestDto){
        this.title = productRequestDto.getTitle();
        this.link = productRequestDto.getLink();
        this.image = productRequestDto.getImage();
        this.lprice = productRequestDto.getLprice();
        this.myprice = 0;

    }
    public void updateByItemDto (ItemDto itemDto){
        this.lprice = itemDto.getLprice();
    }

    public void update(ProductMypriceRequestDto productMypriceRequestDto){
        this.myprice = productMypriceRequestDto.getMyprice();
    }

}
