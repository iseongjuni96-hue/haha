package com.example.demo.JavaBase;

import java.util.Scanner;

public class Base3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수 입력:");
        int score = sc.nextInt();
        if(score >= 90) {
            System.out.println("A");
        }else if (score >= 80) {
            System.out.println("B");
        } 
        else if (score >=70) {
            System.out.println("C");
        }
        else {
            System.out.println("D");
        }

        }
    }
