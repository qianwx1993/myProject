package com.qwx;

import com.alibaba.fastjson.JSON;
import com.qwx.myProject.MyProjectApplication;
import com.qwx.myProject.bo.DistributeBo;
import com.qwx.myProject.strategy.AbstractDistributor;
import com.qwx.myProject.strategy.DistributorFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/4/7 23:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
@Slf4j
public class DistributorTest {
	static final String beanName="defaultSmartDistributor";
	@Autowired
	DistributorFactory distributorFactory;

	/**
	 * 测试分配
	 */
	@Test
	public void distribute() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		AbstractDistributor distributor = distributorFactory.getBean(beanName);
		DistributeBo bo = distributor.distribute();
		System.out.println("返回=======>"+JSON.toJSONString(bo));
	}
}
