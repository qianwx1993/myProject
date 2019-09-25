package com.qwx.myProject.exception;

import com.qwx.myProject.common.ErrorCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author KCF
 * www.bsfit.com.cn
 *2019年7月1日
 */
@Data
@Slf4j
public class AppException extends RuntimeException {
	
	public final static String SYSID_CM = "01"; //卡管 
	public final static String SYSID_FILE = "02";//认证系统及省公安
	public final static String SYSID_FACE = "03";  //私有化平台

	private String code;
	
	private String sysid;

	private String message;
	
	public AppException(String sysid,ErrorCode errorcode ) {
		super(errorcode.code);
		this.sysid = sysid;
		this.code = errorcode.code;
		this.message = errorcode.desc;
	}
	
	public AppException(ErrorCode errorcode ) {
		super(errorcode.code);
		this.code = errorcode.code;
		this.message = errorcode.desc;
	}
	

	public AppException(String errorcode,String message) {
		this.code = errorcode;
		this.message = message;
	}


}
