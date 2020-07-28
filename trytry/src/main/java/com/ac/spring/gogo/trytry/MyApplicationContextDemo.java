package com.ac.spring.gogo.trytry;

public class MyApplicationContextDemo {
    public static void main(String[] args) {
        MyApplicationContext applicationContext = new MyApplicationContext();
        applicationContext.add(1);
        Object o = applicationContext.get(0);
        System.out.println(o);
    }
}
