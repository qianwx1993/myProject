package com.qwx.myProject.common;

public enum ErrorCode {
	SUCCESS("00", "success"),
	MCHNT_ERR1("C1", "该交易未授权"),
	MCHNT_ERR2("C2", "终端未关联商户"),
	MCHNT_ERR3("C3", "商户号状态不允许操作"),
	MCHNT_ERR4("C4", "终端和商户不匹配"),
	
	SIGN_ERR1("B1", "签名不能为空"),
	SIGN_ERR2("B2", "签名验证失败"),
	
	SQL_ERR1("D1", "流水号不能重复"),
	SQL_ERR2("D2", "参数错误"),
	
	APP_ERR1("A1", "终端号faceAppId不能为空"),
	APP_ERR2("A2", "终端号faceAppId不存在"),
	APP_ERR3("A3", "终端号faceAppId状态不允许操作"),
	APP_ERR4("A4", "未绑定的终端不能交易"),
	APP_ERR5("A5", "终端不能重复绑定"),
	APP_ERR6("A6", "请求流水不能为空"),
	APP_ERR7("A7", "请求时间不能为空或者格式不正确"),
	APP_ERR8("A8", "摄像头编号不存在"),
	APP_ERR9("A9", "该摄像头不允许绑定"),
	
	SMKAI_ERR0("F1", "图片上传失败"),
	SMKAI_ERR2("F2", "图片地址获取失败"),
	BUS_ERR5("B5", "用户添加失败"),
	BUS_ERR6("B6", "用户数据不一致"),
	BUS_ERR7("B7", "人脸对比异常"),
	BUS_ERR8("B8", "人脸对比失败"),
	BUS_ERR9("B9", "身份信息不匹配"),
	
	BUS_ERR_D5("D5", "不能重复添加分组"),
	BUS_ERR_D6("D6", "用户检索失败"),
	BUS_ERR_D7("D7", "无效的TOKEN或者是已超时"),
	BUS_ERR_D8("D8", "二次校验数据不能为空"),
	BUS_ERR_D9("D9", "二次校验失败"),
	
	BUS_ERR_B5("B5", "未查到用户信息或者身份信息不匹配"),
	BUS_ERR_B6("B6", "未查到分组信息"),
	
	SYSTEM_ERROR("EE", "system error"),

	PARAM_ERROR("E1","参数错误"),
	DATA_BASE_ERROR("E2","数据库异常"),

	IDENTFI_FIND_USER_EXCEPTION("F3","查询用户失败或无用户信息"),

	DATA_NOT_FOUND_EXCEPTION("F4","数据未找到异常"),
	DATA_STATE_EXCEPTION("F5","数据状态异常"),

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
