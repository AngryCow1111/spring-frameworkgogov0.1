package com.ac.spring.gogo.trytry;

/**
 * 修饰符访问范围示例
 */
public class ModifierAccessScopeDemo {
    public static void main(String[] args) {
        PrivateFinalClass privateFinalClass = new PrivateFinalClass();
        privateFinalClass.init();
        System.out.println(privateFinalClass);
    }
}
