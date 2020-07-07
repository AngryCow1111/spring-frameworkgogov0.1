package com.ac.spring.gogo.aware;

import com.ac.spring.gogo.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class AnnotationBeanRegisterDemo implements InitializingBean {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ac.spring.gogo.aware");
        User user = applicationContext.getBean("user", User.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    // static 必须加否则在启动的时候会报错;此时,普通内部版只有在外边实例化时才会才会被加载.
    @Component
    static class AnnotationBeanConfig {
        @Bean
        public User user() {
            return createUser();
        }
    }

    private static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("angrycow1111");
        return user;
    }

}
