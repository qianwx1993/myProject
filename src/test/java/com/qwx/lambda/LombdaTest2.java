package com.qwx.lambda;

import org.junit.Test;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/4/30 16:21
 */
public class LombdaTest2 {

	@Test
	public void test2() {
		Runnable runnable=()-> System.out.println("线程启动了");
		runnable.run();
	}
}
