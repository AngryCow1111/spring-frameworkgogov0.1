package com.ac.spring.gogo.aware;

import com.ac.spring.gogo.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanCreationAwareDemo
 * bean 创建 aware回调示例
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/6/5
 */
public class BeanCreationAwareDemo {
    public static void main(String[] args) {
        String location = "/META-INF/user-bean.xml";
        // 根据配置文件加载bean
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(location);
        // 开启上下文
        classPathXmlApplicationContext.refresh();
        User user11 = classPathXmlApplicationContext.getBean("user1", User.class);
//        UserHolder userHolder = classPathXmlApplicationContext.getBean("userHolder", UserHolder.class);
//        System.out.println("获得的bean userHolder: " + userHolder);
        //关闭上下文
        classPathXmlApplicationContext.close();


        // AbstractApplicationContext->conversionService->BeanFactory->//
        // BeanWrapperImpl->PropertyValues->BeanDefinition#setPropertyValues->BeanDefinition->ConstructorResolver->BeanFactory->BeanWrapperImpl
    }
}