package com.qwx.myProject.service;

import com.baidu.aip.face.AipFace;
import com.qwx.myProject.form.req.baidu.FaceAddForm;
import com.qwx.myProject.form.res.BaseResForm;
import org.json.JSONObject;

/**
 * baidu人脸接口
 * @Auther: qian
 * @Date: 2019/9/5 20:38
 * @Company Bangsun
 * @Description:
 */
public interface BaiduFaceAiService {

	/**
	 * 获取百度api客户端
	 * @return
	 */
	AipFace getAipFace();

	/**
	 * 鉴权认证，获取Access Token
	 * @return
	 */
	String getAuth();

	/**
	 * 人脸检测
	 * @return
	 */
	JSONObject faceDetect(String image, String imageType, String faceField, String maxFaceNum,String faceType,String livenessControl);

	/**
	 * 人脸注册
	 * @return
	 */
	com.alibaba.fastjson.JSONObject faceAdd(FaceAddForm faceAddForm);

	/**
	 * 添加分组
	 * @param groupId
	 * @return
	 */
	BaseResForm groupAdd(String groupId);

	/**
	 * 百度提供的添加分组
	 * @param groupId
	 * @return
	 */
	BaseResForm groupAdd2(String groupId);
}
