package com.qwx.myProject.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author HYK
 * @Company bangsun
 * @Date 2018/11/22 0022 10:44
 */
@Data
@Slf4j
public class AiException extends RuntimeException {

	private String code;

	public AiException(String message) {
		super(message);
		this.code = code;
	}

}
