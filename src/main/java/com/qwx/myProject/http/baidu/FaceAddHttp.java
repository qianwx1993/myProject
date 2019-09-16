package com.qwx.myProject.http.baidu;

import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.form.req.baidu.BaseReqForm;
import com.qwx.myProject.form.req.baidu.FaceAddForm;
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
public class FaceAddHttp extends BaiduBaseHttp {

	private static final String sendUrl = "user/add";
	/**
	 * 发送http请求
	 * @param faceAddForm
	 * @return
	 */
	public JSONObject doPost(String accessToken, FaceAddForm faceAddForm) {
		JSONObject faceAddFormJson = new JSONObject();
		faceAddFormJson.put("image",faceAddForm.getImage());
		faceAddFormJson.put("image_type",faceAddForm.getImage_type());
		faceAddFormJson.put("group_id",faceAddForm.getGroup_id());
		faceAddFormJson.put("user_id",faceAddForm.getUser_id());
		faceAddFormJson.put("user_info",faceAddForm.getUser_info());
		faceAddFormJson.put("quality_control",faceAddForm.getQuality_control());
		faceAddFormJson.put("liveness_control",faceAddForm.getLiveness_control());
		faceAddFormJson.put("action_type",faceAddForm.getAction_type());

		BaseReqForm baseReqForm=new BaseReqForm();
		baseReqForm.setAccess_token(accessToken);
		baseReqForm.setBody(faceAddFormJson.toJSONString());

		JSONObject baseReqFormJsonObj = JSONObject.parseObject(JSONObject.toJSONString(baseReqForm));

		return doPost(sendUrl, baseReqFormJsonObj);
	}

}
