package com.sparta.homework01.controller;

import com.sparta.homework01.person.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPersons() {
        Person person = new Person();
        person.setName("정석진");
        person.setAge(26);
        person.setEmail("strong1133@naver.com");
        return person;
    }
}
