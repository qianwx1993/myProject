package com.qwx.copy;/**
 * @Auther: qian
 * @Date: 2020/3/3 12:30
 * @Company Bangsun
 * @Description:
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 12:30
 */
@Data
public class Beauty implements Serializable {

	private String name;
	private int level;
	private double face;

	public Beauty() {}

	public Beauty(String name, int level, double face) {
		this.setName(name);
		this.setLevel(level);
		this.setFace(face);
	}

	@Override
	public String toString() {
		return name + ", " + level + ", " + face;
	}

	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}*/
}
