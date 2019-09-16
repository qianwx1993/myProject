package com.qwx.myProject.http.baidu;

import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.http.BaseHttp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 百度http
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/16 16:37
 */
@Component
public class BaiduBaseHttp extends BaseHttp {
	@Value("${baidu_ai.url}")
	private String baseSendUrl;
	/**
	 * 记录日志，再发送http请求
	 * @param url
	 * @param sendJson
	 * @return
	 */
	@Override
	public JSONObject doPost(String url, JSONObject sendJson) {
		url=baseSendUrl+url;
		//请求
		JSONObject retjsonObj = super.doPost(url, sendJson);

		return retjsonObj;
	}

}
