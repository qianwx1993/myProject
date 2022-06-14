package com.qwx.myProject.abstract_method.entity;

import lombok.Data;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/6/15 0:53
 */
@Data
public class SalesOrderEntityResponse extends SalesEntityResponse<SalesOrder, SalesOrderItem>{
	private String testName;
}
