package com.qwx.myProject.condition.impl2;

import com.qwx.myProject.condition.FoodService;
import com.qwx.myProject.condition.impl.DogServiceImpl;
import com.qwx.myProject.condition.impl.PigServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/17 23:27
 */
@Service
@ConditionalOnBean(PigServiceImpl.class)
public class FodderFoodService implements FoodService {
	@Override
	public String tag() {
		String s="我是猪饲料";
		System.out.println(s);
		return s;
	}
}
