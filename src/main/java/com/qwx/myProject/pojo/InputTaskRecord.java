package com.qwx.myProject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/4/7 23:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputTaskRecord {
	private String batchNo;
	private String planId;
	private String creator;
	private String createOrg;
}
