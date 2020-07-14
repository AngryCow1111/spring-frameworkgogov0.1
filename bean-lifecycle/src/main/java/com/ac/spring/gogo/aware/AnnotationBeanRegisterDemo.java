package com.ac.spring.gogo.aware;

import com.ac.spring.gogo.domain.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;


public class AnnotationBeanRegisterDemo implements InitializingBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ac.spring.gogo.aware");

        ScopeMetadataResolver scopeMetadataResolver = new AnnotationScopeMetadataResolver(ScopedProxyMode.INTERFACES);
        applicationContext.setScopeMetadataResolver(scopeMetadataResolver);
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class, () -> createUser1());
//        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        defaultListableBeanFactory.registerBeanDefinition("user1", beanDefinition);
//
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(defaultListableBeanFactory);
//        applicationContext.getBeanDefinitionNames();
//        applicationContext.refresh();
        User user = applicationContext.getBean("user1", User.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    private static User callback() {
        return createUser();
    }

    // static 必须加否则在启动的时候会报错;此时,普通内部版只有在外边实例化时才会才会被加载.
    // 注册bean的时候加载别名相关的元信息
    @Component
    static class AnnotationBeanConfig {
        @Bean(name = {"user1", "user2"})
        public User user() {
            return createUser();
        }
    }

    private static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("angrycow1111");
        System.out.println(user);
        return user;
    }

    private static User createUser1() {
        User user = new User();
        user.setId(1L);
        user.setName("angrycow");
        return user;
    }
}
