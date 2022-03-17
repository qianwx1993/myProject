package com.qwx.myProject.controller;

import com.qwx.myProject.condition.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/17 23:04
 */
@RestController
@RequestMapping("/conditional")
public class ConditionalOnPropertyController {
	//注入AnimalService
	@Autowired
	private AnimalService animalService;

	@GetMapping("/test")
	public String test(){
		return animalService.say()+"=====,吃："+animalService.eat();
	}
}
