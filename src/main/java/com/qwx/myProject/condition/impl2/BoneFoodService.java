package com.qwx.myProject.condition.impl2;

import com.qwx.myProject.condition.FoodService;
import com.qwx.myProject.condition.impl.CatServiceImpl;
import com.qwx.myProject.condition.impl.DogServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/17 23:27
 */
@Service
@ConditionalOnBean(DogServiceImpl.class)
public class BoneFoodService implements FoodService {
	@Override
	public String tag() {
		String s="我是骨头";
		System.out.println(s);
		return s;
	}
}
