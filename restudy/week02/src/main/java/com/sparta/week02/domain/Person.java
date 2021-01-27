package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
    }

    public void update(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.age = personRequestDto.getAge();
    }
}
