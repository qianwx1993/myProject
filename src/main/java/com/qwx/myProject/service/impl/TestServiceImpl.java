package com.qwx.myProject.service.impl;/**
 * @Auther: qian
 * @Date: 2019/1/9 16:46
 * @Company Bangsun
 * @Description:
 */

import com.qwx.myProject.service.TestService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/9 16:46
 */
@Slf4j
public class TestServiceImpl implements TestService {
	@Override
	public void save() {
		log.info("进入了save方法，保存了数据");
	}
}
