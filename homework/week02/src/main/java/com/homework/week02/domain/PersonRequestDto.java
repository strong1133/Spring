package com.homework.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PersonRequestDto {
    private String name;
    private String age;
    private String nik;

    public PersonRequestDto(String name, String age, String nik) {
        this.name = name;
        this.age = age;
        this.nik = nik;
    }
}
