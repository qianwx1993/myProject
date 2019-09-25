package com.qwx.myProject.controller;

import com.qwx.myProject.common.ErrorCode;
import com.qwx.myProject.exception.AppException;
import com.qwx.myProject.form.req.baidu.FaceAddReqForm;
import com.qwx.myProject.form.res.BaseResForm;
import com.qwx.myProject.form.res.FaceAddResForm;
import com.qwx.myProject.service.BaiduFaceAiService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/5 10:05
 */
@Controller
@Slf4j
@RequestMapping("qwx/api")
public class ApiController {

	@Resource
	private BaiduFaceAiService baiduFaceAiService;

	@PostMapping("faceAdd")
	public BaseResForm faceAdd(@Valid @RequestBody FaceAddReqForm form, BindingResult bindingResul) {
		if (bindingResul.hasErrors()) {
			String errMsg = bindingResul.getFieldError().getDefaultMessage();
			return BaseResForm.back(ErrorCode.PARAM_ERROR.code, errMsg);
		}
		JSONObject detectJson = baiduFaceAiService.faceDetect(form.getImage(), form.getImage_type());
		int face_num = detectJson.getInt("face_num");
		if (face_num<=0){
			throw new AppException(ErrorCode.DETECT_FALSE);
		}

		com.alibaba.fastjson.JSONObject faceAddJson = baiduFaceAiService.faceAdd(form);
		if (Objects.equals(null,faceAddJson)){
			return  BaseResForm.back(ErrorCode.FALSE.code,ErrorCode.FALSE.desc);
		}
		FaceAddResForm result=new FaceAddResForm();
		result.setFace_token(faceAddJson.getString("face_token"));
		result.setLog_id(faceAddJson.getString("log_id"));
		return BaseResForm.success(result);
	}

	}
