package com.qwx.beanAutoload2;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * bean的动态装载之ImportBeanDefinitionRegistrar, 仿照@EnableFeignClients的写法
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/11/24 0:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloImportBeanDefinitionRegistrar.class)
public @interface EnableHelloRegistrar {
}
