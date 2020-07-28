package com.ac.spring.gogo.databinding;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类型转换示例
 */
public class MyTypeConverterSupportDemo {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/type-converter.xml");
//        applicationContext.refresh();

    }
}
