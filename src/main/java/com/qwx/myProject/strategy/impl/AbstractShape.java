package com.qwx.myProject.strategy.impl;

import com.qwx.myProject.strategy.Shape;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/10 23:28
 */
public abstract class AbstractShape implements Shape {
	@Override
	public void say(){
		System.out.println("进入了AbstractShape，执行了say：我们都是形状");
	}
}
