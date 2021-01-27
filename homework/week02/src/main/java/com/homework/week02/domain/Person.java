package com.homework.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String age;

    @Column(nullable = false)
    private String nik;

    public Person(String name, String age, String nik){
        this.name = name;
        this.age = age;
        this.nik = nik;
    }
    public Person(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.nik = personRequestDto.getNik();
    }

    public void update(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
        this.nik = personRequestDto.getNik();
    }

}
