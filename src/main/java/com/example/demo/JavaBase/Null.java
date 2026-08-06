package com.example.demo.JavaBase;

import java.util.Scanner;

public class Null {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("단 입력:");
        int dan = sc.nextInt();

        for(int i=1; i<=9; i++) {
            System.out.println(dan + "x" + i + "=" +(dan*i));
        }
    }
}
