package com.qwx.myProject.form.req.baidu;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/9/16 20:27
 */
@Data
public class FaceAddReqForm {
	@NotBlank(message = "image不能为空")
	private String image;
	@NotBlank(message = "image_type不能为空")
	private String image_type;
	@NotBlank(message = "group_id不能为空")
	private String group_id;
	@NotBlank(message = "user_id不能为空")
	private String user_id;

	private String user_info;

	private String quality_control;

	private String liveness_control;

	private String action_type;
}
