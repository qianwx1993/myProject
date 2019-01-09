package com.qwx.myProject.config;/**
 * @Auther: qian
 * @Date: 2019/1/9 16:51
 * @Company Bangsun
 * @Description:
 */

import com.qwx.myProject.service.TestService;
import com.qwx.myProject.service.impl.TestServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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
}
