package com.sparta.homework01.person;

public class Person {
    private String name;
    private int age;
    private String email;

    public Person() {

    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getter
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getEmail() {
        return this.email;
    }

}
