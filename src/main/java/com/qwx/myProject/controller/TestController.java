package com.qwx.myProject.controller;

import com.qwx.myProject.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/9 16:38
 */
@Slf4j
@Controller
public class TestController {
	@Resource
	TestService testService1;

	@GetMapping("test1")
	public String test1(){
		testService1.save();
		return "请求save方法";
	}
}
