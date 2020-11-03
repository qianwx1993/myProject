package com.qwx.myProject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/3 15:40
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
@ToString
public class User {
	private String username;
	private String passWord;
	private int age;
}
