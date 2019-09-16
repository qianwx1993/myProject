package com.qwx.baidu.face.api;

import com.qwx.myProject.MyProjectApplication;
import com.qwx.myProject.form.req.baidu.FaceAddForm;
import com.qwx.myProject.service.BaiduFaceAiService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/5 21:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
@Slf4j
public class BaiduFaceApiTest {
	@Resource
	private BaiduFaceAiService baiduFaceAiService;
	@Value("${image}")
	private String image;
	@Test
	public void detect(){
		String imageType="BASE64";
		log.debug("图片base64编码"+image);
		JSONObject retJson = baiduFaceAiService.faceDetect(image,
				imageType, "", "", "", "");

		log.info("人脸检测结果"+retJson.toString());
	}

	@Test
	public void getAuthTest(){
		String auth = baiduFaceAiService.getAuth();
		System.err.println("Access Token："+auth);
	}

	@Test
	public void faceAddTest(){
		FaceAddForm faceAddForm=new FaceAddForm();
		faceAddForm.setImage(image);
		faceAddForm.setImage_type("BASE64");
		faceAddForm.setGroup_id("100");
		faceAddForm.setUser_id("100");

		com.alibaba.fastjson.JSONObject jsonObject = baiduFaceAiService.faceAdd(faceAddForm);

		System.err.println("jsonObject返回："+jsonObject.toJSONString());
	}
}
