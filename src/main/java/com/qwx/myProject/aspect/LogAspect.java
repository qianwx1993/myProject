package com.qwx.myProject.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author HYK
 * @Company bangsun
 * @Date 2018年11月22日 10:24:13s
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

	private static final int LOG_LENGTH = 500;

	@Around("execution(* com.qwx.myProject.controller..*(..))")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
		Object args[] = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		String reqParams = StringUtils.join(args, ";");
		if (reqParams.length() > LOG_LENGTH) {
			log.info("请求日志过长,进行截取,长度:{}", LOG_LENGTH);
			reqParams = reqParams.substring(0, LOG_LENGTH);
		}
		log.info("调用开始--> {}.{} : 前台请求参数:{}", method.getDeclaringClass().getName(), method.getName(), reqParams);
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long dealTime = System.currentTimeMillis() - startTime;
		String resStr = JSONObject.toJSONString(result, SerializerFeature.WriteMapNullValue);
		if (resStr.length() > LOG_LENGTH) {
			log.info("返回日志过长,进行截取,长度:{}", LOG_LENGTH);
			resStr = resStr.substring(0, LOG_LENGTH);
		}
		log.info("调用结束--> 返回值:{}  耗时:{}ms", resStr, dealTime);

		return result;
	}
	
	
	
	

}
