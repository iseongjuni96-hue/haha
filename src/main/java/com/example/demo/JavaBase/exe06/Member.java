package com.example.demo.JavaBase.exe06;

public class Member {
    String id;
    String name;
    int age;

    public Member(String id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public void printInfo() {
        System.out.println("아이디:" +id+ ",이름: " +name+ ",나이:" +age);
    }
}
