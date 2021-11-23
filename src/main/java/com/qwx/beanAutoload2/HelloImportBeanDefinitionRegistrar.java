package com.qwx.beanAutoload2;

import com.qwx.beanAutoload1.demo.HelloService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/11/24 0:20
 */
public class HelloImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName(HelloService.class.getName());
		registry.registerBeanDefinition("helloService", beanDefinition);
	}
}
