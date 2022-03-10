package com.qwx.myProject.strategy.impl;

import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/10 23:30
 */
@Service
public class Circle extends AbstractShape{
	@Override
	public void draw() {
		System.out.println("画了个圆形");
	}
}
