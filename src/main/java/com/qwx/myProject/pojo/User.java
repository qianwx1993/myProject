package com.qwx.myProject.pojo;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/3 15:40
 */
public class User {
	private String username;
	private String passWord;
	private int age;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public String getPassWord() {
		return passWord;
	}

	public int getAge() {
		return age;
	}
}
