package com.qwx.myProject.service.impl;

import com.baidu.aip.face.AipFace;
import com.qwx.myProject.service.BaiduFaceAiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/5 20:44
 */
@Service
public class BaiduFaceAiServiceImpl implements BaiduFaceAiService {

	@Value("${baidu_ai.appid}")
	private String appId;

	@Value("${baidu_ai.apikey}")
	private String apiKey;

	@Value("${baidu_ai.secret_key}")
	private String secretKey;

	@Override
	public AipFace getAipFace() {
		AipFace client = new AipFace(appId, apiKey, secretKey);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		return client;
	}

	@Override
	public JSONObject faceDetect(String image, String imageType, String faceField, String maxFaceNum,String faceType,String livenessControl) {

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		//options.put("face_field", faceField);
		//options.put("max_face_num", maxFaceNum);
		//options.put("face_type", faceType);
		//options.put("liveness_control", livenessControl);
		return getAipFace().detect(image,imageType,options);
	}
}
