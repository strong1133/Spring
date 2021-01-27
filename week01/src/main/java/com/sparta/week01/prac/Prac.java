package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {

    //메소드
    public static void printInfo() {
        String title = "웹개발의 봄 Spring";
        String tutor = "남병관";
        int weeks = 5;
        float ratings = 5.0f;

        System.out.println("제목: " + title);
        System.out.println("튜터: " + tutor);
        System.out.println("주차: " + weeks);
        System.out.println("별점: " + ratings);
        System.out.println();
    }

    public static int sub(int num1, int num2) {
        return num1 - num2;
    }

    public static void main(String[] args) {

//        String title = "웹개발의 봄 Spring";
//        String tutor = "남병관";
//        int days = 35;
//        Course course = new Course();
//        course.setTitle(title);
//        course.setTutor(tutor);
//        course.setDays(days);
//        System.out.println(course.getTitle());
//        System.out.println(course.getTutor());

        String name = "남병관";
        int bio = 10;
        Tutor tutor = new Tutor();
        tutor.setName(name);
        tutor.setBio(bio);
        System.out.println(tutor.getName());
        System.out.println(tutor.getBio());


//        System.out.println("Hello SJ into Java");
//        String myName = "정석진";
//        System.out.println(myName);
//
//        int a = 7;
//        int b = 3;
//        float c = 3.4f;
//        Long d = 1234223232321233233L;
//
//        System.out.println(a + b);
//        System.out.println(c);
//        System.out.println(d);
//
//        int myAge = 20;
//        boolean isAdult = myAge > 20;
//        boolean isKid = myAge <= 20;
//        System.out.println(isAdult);
//        System.out.println(isKid);
//        System.out.println(myAge == 20); //true
//        System.out.println(myAge != 20); //false
//
//        List<String> myList = new ArrayList<>();
//        String course1 = "웝개발의 봄 Spring";
//        String course2 = "프론트엔드의 꽃 React";
//        myList.add(course1);
//        myList.add(course2);
//        System.out.println(myList);
//        System.out.println(myList.get(1));
//
//        //퀴즈1
//        List<String> courseList = new ArrayList<>();
//        String course3 = "웹개발 종합반";
//        String course4 = "앱개발 종합반";
//        courseList.add(course3);
//        courseList.add(course4);
//        System.out.println(courseList);

//        printInfo();
//        int result = sub(5,2);
//        System.out.println(result);
    }
}
