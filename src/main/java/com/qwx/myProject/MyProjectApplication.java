package com.qwx.myProject;

import com.qwx.beanAutoload1.HelloImportSelector;
import com.qwx.beanAutoload2.EnableHelloRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

//@Import(HelloImportSelector.class)// 通过ImportSelector --- 实现bean的自动装载
@EnableHelloRegistrar // 通过ImportBeanDefinitionRegistrar --- 实现bean的自动装载
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MyProjectApplication.class, args);
		System.out.println("从spring容器中获取对象 HelloService:"+context.getBean("helloService"));
	}
}
