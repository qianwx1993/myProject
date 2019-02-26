package com.qwx.myProject.config;

import com.qwx.myProject.pojo.People;
import com.qwx.myProject.service.TestService;
import com.qwx.myProject.service.impl.TestServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试@Configuration的用法
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/9 16:51
 */
@Configuration
public class ServiceConfig {
	@Bean
	public TestService testService1(){
		return new TestServiceImpl();
	}

	@Bean
	@ConfigurationProperties(prefix = "test.demo.annotation.configurationProperties")
	public People people(){
		return new People();
	}
}
