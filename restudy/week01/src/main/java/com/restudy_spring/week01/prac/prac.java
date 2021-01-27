package com.restudy_spring.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class prac {

    public static void main(String[] args) {
        Tutor tutor = new Tutor();

        tutor.setName("남병관");
        tutor.setBio(20);

        System.out.println(tutor.getName());
        System.out.println(tutor.getBio());
    }
}
