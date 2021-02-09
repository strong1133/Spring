package com.restudy.week04.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String link;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    private int lprice;
    @Column(nullable = false)
    private int myprice;

    public Product(ProdcutRequestDto prodcutRequestDto) {
        this.title = prodcutRequestDto.getTitle();
        this.link = prodcutRequestDto.getLink();
        this.image = prodcutRequestDto.getImage();
        this.lprice = prodcutRequestDto.getLprice();
        this.myprice = 0;
    }

    public void update(ProductMypriceRequestDto productMypriceRequestDto) {
        this.myprice = productMypriceRequestDto.getMyprice();
    }
}
