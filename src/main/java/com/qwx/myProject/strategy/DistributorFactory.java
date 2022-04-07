package com.qwx.myProject.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/4/7 23:28
 */
@Component
public class DistributorFactory {
	@Autowired
	private Map<String, AbstractDistributor> distributorMap;

	public AbstractDistributor getBean(String beanName) {
		return distributorMap.get(beanName);
	}
}
