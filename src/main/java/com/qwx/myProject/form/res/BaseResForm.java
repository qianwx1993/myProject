package com.qwx.myProject.form.res;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.qwx.myProject.common.ErrorCode;
import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author qian
 * @Company bangsun
 * @Date 2019/09/17 10:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResForm {

	private String code;

	private String message;
	
	private String sign;
	
	private String centSeq;

	private Object data;

	public static BaseResForm success() {
		BaseResForm baseResForm = new BaseResForm();
		baseResForm.setCode(ErrorCode.SUCCESS.code);
		baseResForm.setMessage(ErrorCode.SUCCESS.desc);
		return baseResForm;
	}

	public static BaseResForm success(Object data) {
		BaseResForm baseResForm = new BaseResForm();
		baseResForm.setCode(ErrorCode.SUCCESS.code);
		baseResForm.setMessage(ErrorCode.SUCCESS.desc);
		baseResForm.setData(data);
		return baseResForm;
	}

	public static BaseResForm back(String code, String msg) {
		BaseResForm baseResForm = new BaseResForm();
		baseResForm.setCode(code);
		baseResForm.setMessage(msg);
		return baseResForm;
	}

	public static BaseResForm back(ErrorCode errorCode) {
		BaseResForm baseResForm = new BaseResForm();
		baseResForm.setCode(errorCode.getCode());
		baseResForm.setMessage(errorCode.getDesc());
		return baseResForm;
	}

}
