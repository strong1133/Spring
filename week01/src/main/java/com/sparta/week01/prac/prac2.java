package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class prac2 {

    public static int countFruits(String given) {
        List<String> fruits = new ArrayList<>();
        fruits.add("감");
        fruits.add("사과");
        fruits.add("딸기");
        fruits.add("수박");
        fruits.add("감");
        fruits.add("메론");
        fruits.add("감");
        fruits.add("수박");
        fruits.add("사과");
        fruits.add("메론");

        int count = 0;
        for (int i = 0; i < fruits.size(); i++) {
            String fruit = fruits.get(i);
            if (given == fruit) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {


        //퀴즈
        List<String> celebs = new ArrayList<>();
        celebs.add("아이유");
        celebs.add("김다미");
        celebs.add("유재석");
        celebs.add("비");
        celebs.add("린다G");
        celebs.add("수지");
        celebs.add("소지섭");
        celebs.add("정우성");
        celebs.add("남주혁");

        for (int i = 0; i < celebs.size(); i++) {
            String celeb = celebs.get(i);
            System.out.println(celeb);
        }

        //조건문 퀴즈
        int age = 20;
        if (age > 19) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }

        System.out.println("======================================");

        int gam = countFruits("감");
        System.out.println(gam);


    }
}
