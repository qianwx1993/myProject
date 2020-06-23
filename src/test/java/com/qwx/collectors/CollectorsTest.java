package com.qwx.collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/6/23 17:30
 */
public class CollectorsTest {
	@Test
	public void test1(){
		List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6d),
				new Fruit("apple", 6d),
				new Fruit("banana", 7d), new Fruit("banana", 7d),
				new Fruit("banana", 7d), new Fruit("grape",8d));

		Map<String, Long> map = fruitList.stream().
				collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));
	}
}
