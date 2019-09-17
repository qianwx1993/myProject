package com.qwx.myProject.http.baidu;

import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.http.BaseHttp;
import com.qwx.myProject.util.GsonUtils;
import com.qwx.myProject.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 百度http
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/16 16:37
 */
@Component
@Slf4j
public class BaiduBaseHttp {
	@Value("${baidu_ai.url}")
	private String baseSendUrl;

	@Value("${baidu_ai.access_token}")
	private String accessToken;
	/**
	 * 记录日志，再发送http请求
	 * @param url
	 * @param map
	 * @return
	 */
	public JSONObject doPost(String url, Map<String,Object> map) {
		JSONObject resultJson=new JSONObject();
		url=baseSendUrl+url;
		//请求
		String param = JSONObject.toJSONString(map);

		try {
			log.debug("请求百度：地址:{},请求参数:{}",url,param);
			String result = HttpUtil.post(url, accessToken, "application/json", param);
			resultJson = JSONObject.parseObject(result);
			log.debug("百度返回参数：{}",resultJson.toJSONString());
			return resultJson;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			resultJson.put("error_code","EE");
			resultJson.put("error_msg","系统异常");
			return resultJson;
		}

	}

}
