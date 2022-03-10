package com.qwx.myProject.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2022/3/10 23:33
 */
@Component
public class ShapeBeanFactory {
	@Autowired
	private Map<String, Shape> shapeMap;

	@Autowired
	private List<Shape> shapeList;

	public Shape getShape(String shapeType) {
		if ("1".equals(shapeType)){
			return shapeMap.get("circle");
		}else if ("2".equals(shapeType)){
			return shapeMap.get("rectangle");
		}if ("3".equals(shapeType)){
			return shapeMap.get("square");
		}
		return null;
		//Shape bean1 = shapeMap.get(shapeType);
		//System.out.println(bean1);
		//return bean1;
	}

}
