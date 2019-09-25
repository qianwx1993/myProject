package com.qwx.myProject.common;

public enum ErrorCode {
	SUCCESS("00", "success"),
	DETECT_FALSE("01", "人脸检测失败"),
	SYSTEM_ERROR("EE", "system error"),
	PARAM_ERROR("E1","参数错误"),
	DATA_BASE_ERROR("E2","数据库异常"),

	FALSE("F6","失败");

	public String code;

	public String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private ErrorCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
