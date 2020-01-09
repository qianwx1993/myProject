package com.qwx.jvmtest;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/1/7 20:53
 */
public class Test3 {
	public static void main(String[] args) {
		new Test3().m1();
		new Test3().m2();
	}

	public void m1(){
		String s1 = "123";
		String s2 = "456";
		String s3 = s1 + s2;
		System.out.println(s3);
	}
	public void m2() {
		String s1 = "123";
		String s2 = "456";
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		sb.append(s2);
		String s3 = sb.toString();
		System.out.println(s3);
	}
}
