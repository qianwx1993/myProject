package com.qwx.myProject.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/2/26 15:43
 */
@Data
@ToString
public class People {
	private String name;

	private Integer age;

	private List<String> address;

	private String phone;

}
