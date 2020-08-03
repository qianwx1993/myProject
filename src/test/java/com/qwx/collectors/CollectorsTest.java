package com.qwx.collectors;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/6/23 17:30
 */
@Slf4j
public class CollectorsTest {
	@Test
	public void test1(){
		List<Fruit> fruitList = Lists.newArrayList(new Fruit("apple", 6d),
				new Fruit("apple", 6d),
				new Fruit("banana", 7d), new Fruit("banana", 7d),
				new Fruit("banana", 7d), new Fruit("grape",8d));
		//计数
		Map<String, Long> map = fruitList.stream().
				collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));
		for (String s : map.keySet()) {
			log.info("map键值对：{}={}",s,map.get(s));
		}
		//现在要按照水果map中value的数量逆序打印每个entry
		map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
					.forEachOrdered(System.out::println);
		//累加求和
		Map<String, Double> sumMap = fruitList.stream().collect
					(Collectors.groupingBy(Fruit::getName, Collectors.summingDouble(Fruit::getPrice)));
		for (String s : sumMap.keySet()) {
			log.info("sumMap键值对：{}={}",s,sumMap.get(s));
		}
		//分组
		Map<String, List<Fruit>> groupMap =
					fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
		for (String s : groupMap.keySet()) {
			log.info("groupMap键值对：{}={}",s,groupMap.get(s));
		}
	}

	@Test
	public void test2(){
		System.out.println("随机值："+ThreadLocalRandom.current().nextInt(10));
	}
}
