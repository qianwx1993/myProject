package com.qwx.myProject.http.baidu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.form.req.baidu.BaseReqForm;
import com.qwx.myProject.form.req.baidu.FaceAddForm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
public class GroupAddHttp extends BaiduBaseHttp {

	private static final String sendUrl = "group/add";
	/**
	 * 发送http请求
	 * @param groupId
	 * @return
	 */
	public JSONObject doPost( String groupId) {
		Map<String,Object> map=new HashMap<>();
		map.put("group_id",groupId);
		return super.doPost(sendUrl, map);
	}

}
