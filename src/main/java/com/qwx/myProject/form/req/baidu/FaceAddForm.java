package com.qwx.myProject.form.req.baidu;

import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/16 20:27
 */
@Data
public class FaceAddForm {
	private String image;

	private String image_type;

	private String group_id;

	private String user_id;

	private String user_info;

	private String quality_control;

	private String liveness_control;

	private String action_type;
}
