package com.qwx.myProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2021/2/5 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
public class WebStarterTester {

	@Autowired
	RestTemplate restTemplate;
	@Test
	public void testRestTemplate(){
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://www.baidu.com", String.class);
		System.out.println("返回："+forEntity.toString());
	}

}
