package com.ac.spring.gogo.trytry;

public class StaticMethod {


    public static void publicStaticMethod() {
        privateStaticMethod1();
    }

    private static void privateStaticMethod1() {
        System.out.println("invoke private static method1");
    }
}
