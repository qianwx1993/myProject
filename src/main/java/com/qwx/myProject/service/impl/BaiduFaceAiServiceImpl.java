package com.qwx.myProject.service.impl;

import com.baidu.aip.face.AipFace;
import com.qwx.myProject.common.ErrorCode;
import com.qwx.myProject.exception.AppException;
import com.qwx.myProject.form.req.baidu.FaceAddReqForm;
import com.qwx.myProject.form.res.BaseResForm;
import com.qwx.myProject.http.baidu.FaceAddHttp;
import com.qwx.myProject.http.baidu.GroupAddHttp;
import com.qwx.myProject.service.BaiduFaceAiService;
import com.qwx.myProject.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/5 20:44
 */
@Service
@Slf4j
public class BaiduFaceAiServiceImpl implements BaiduFaceAiService {

	@Value("${baidu_ai.appid}")
	private String appId;

	@Value("${baidu_ai.apikey}")
	private String apiKey;

	@Value("${baidu_ai.secret_key}")
	private String secretKey;

	@Value("${baidu_ai.access_token}")
	private String accessToken;

	public final static String tokenUrl="https://aip.baidubce.com/oauth/2.0/token?";
	public final static String userAddUrl="https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";

	@Resource
	private FaceAddHttp faceAddHttp;
	@Resource
	private GroupAddHttp groupAddHttp;

	@Override
	public AipFace getAipFace() {
		AipFace client = new AipFace(appId, apiKey, secretKey);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		return client;
	}

	@Override
	public String getAuth() {
		// 获取token地址
		String authHost = tokenUrl;
		// 1. grant_type为固定参数；2. 官网获取的 API Key；3. 官网获取的 Secret Key
		String getAccessTokenUrl = authHost
				+ "grant_type=client_credentials"
				+ "&client_id=" + apiKey
				+ "&client_secret=" + secretKey;
		try {
			URL realUrl = new URL(getAccessTokenUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.err.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			/**
			 * 返回结果示例
			 */
			System.err.println("result:" + result);
			log.info("result:" + result);
			JSONObject jsonObject = new JSONObject(result);
			String access_token = jsonObject.getString("access_token");
			return access_token;
		} catch (Exception e) {
			System.err.printf("获取token失败！");
			log.error("获取token失败！"+e.getMessage(),e);
		}
		return null;
	}

	@Override
	public JSONObject faceDetect(String image, String imageType) {

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		JSONObject detect = getAipFace().detect(image, imageType, options);
		log.info("人脸检测返回：{}",detect.toString());
		return getAipFace().detect(image,imageType,options);
	}

	@Override
	public com.alibaba.fastjson.JSONObject faceAdd(FaceAddReqForm faceAddForm) {
		log.info("accessToken为:"+accessToken);

		return faceAddHttp.doPost(accessToken,faceAddForm);
	}

	@Override
	public BaseResForm groupAdd(String groupId) {
		com.alibaba.fastjson.JSONObject retJson = groupAddHttp.doPost(groupId);

		return BaseResForm.success(retJson);
	}

	@Override
	public BaseResForm groupAdd2(String groupId) {

		// 请求url
		String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/group/add";
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("group_id", groupId);

			String param = com.alibaba.fastjson.JSONObject.toJSONString(map);

			// 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。

			String result = HttpUtil.post(url, accessToken, "application/json", param);
			System.err.println(result);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return BaseResForm.back(ErrorCode.FALSE);
		}
		return BaseResForm.success();
	}


}
