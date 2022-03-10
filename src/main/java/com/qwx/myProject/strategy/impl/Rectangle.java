package com.qwx.myProject.strategy.impl;

import com.qwx.myProject.strategy.Shape;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/10 23:26
 */
@Service
public class Rectangle extends AbstractShape {
	@Override
	public void draw() {
		System.out.println("画了个矩形");
	}
}
