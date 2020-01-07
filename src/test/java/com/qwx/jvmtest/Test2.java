package com.qwx.jvmtest;

/**
 * 查看i++与++i的不同
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/12/31 17:23
 */
public class Test2 {
	public static void main(String[] args) {
		new Test2().method1();
		new Test2().method2();
	}

	public void method1(){
		int i = 1;
		int a = i++;
		System.out.println(a); //打印1
	}

	public void method2(){
		int i = 1;
		int a = ++i;
		System.out.println(a);//打印2
	}
}
