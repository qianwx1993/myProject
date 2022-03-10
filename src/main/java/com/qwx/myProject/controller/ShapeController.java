package com.qwx.myProject.controller;

import com.qwx.myProject.strategy.Shape;
import com.qwx.myProject.strategy.ShapeBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/10 23:32
 */
@RestController
@RequestMapping("/shape")
public class ShapeController {
	@Autowired
	private ShapeBeanFactory factory; // 使用注解注入

	@GetMapping("/drawMyShape")
	public String drawMyShape(){
		shapeBeanFactoryDraw();
		return "成功";
	}

	private void shapeBeanFactoryDraw() {
		System.out.println("======= 实现二 shapeBeanFactory =======");
		Shape shapeInterface1 = factory.getShape("1");
		shapeInterface1.draw();
		shapeInterface1.say();

		Shape shapeInterface2 = factory.getShape("2");
		shapeInterface2.draw();
		shapeInterface1.say();
	}
}
