package com.qwx.myProject.condition.impl;

import com.qwx.myProject.condition.AnimalService;
import com.qwx.myProject.condition.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/17 23:12
 */
@ConditionalOnProperty(prefix = "animal",name = "instance",havingValue = "pigService")
@Service
public class PigServiceImpl implements AnimalService {
	@Autowired
	FoodService foodService;
	@Override
	public String say() {
		String s="哼哼哼";
		System.out.println(s);
		return s;
	}

	@Override
	public String eat() {
		return foodService.tag();
	}
}
