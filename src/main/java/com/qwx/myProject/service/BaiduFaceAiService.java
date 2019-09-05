package com.qwx.myProject.service;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

/**
 * baidu人脸接口
 * @Auther: qian
 * @Date: 2019/9/5 20:38
 * @Company Bangsun
 * @Description:
 */
public interface BaiduFaceAiService {

	AipFace getAipFace();
	/**
	 * 人脸检测
	 * @return
	 */
	JSONObject faceDetect();
}
