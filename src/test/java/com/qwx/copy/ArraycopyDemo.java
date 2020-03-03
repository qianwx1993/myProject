package com.qwx.copy;/**
 * @Auther: qian
 * @Date: 2020/3/3 12:31
 * @Company Bangsun
 * @Description:
 */

import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 12:31
 */
public class ArraycopyDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//new ArraycopyDemo().m2();
		//new ArraycopyDemo().m3();
		new ArraycopyDemo().m4();
	}

	/**
	 *
	 * 测试arraycopy方法，当数组内容变成除基本类型和String外的对象后，是深复制还是浅复制？
	 * 结论：当数组内容变成除基本类型和String外的对象后，System.arraycopy是浅复制
	 */
	public void m1(){
		Beauty[] beauties = new Beauty[5];
		beauties[0] = new Beauty("王昭君", 5, 86.25);
		beauties[1] = new Beauty("赵飞燕", 6, 76.25);
		beauties[2] = new Beauty("陈圆圆", 7, 56.25);
		beauties[3] = new Beauty("杨玉环", 8, 66.25);
		beauties[4] = new Beauty("苏妲己", 9, 96.25);
		Beauty[] newBeauties = new Beauty[beauties.length];
		System.arraycopy(beauties, 0, newBeauties, 0, beauties.length);
		//修改复制后数组元素的属性
		newBeauties[1].setName("洛神甄氏");

		//打印原数组中的内容，观察1号元素的name属性，已经被修改了
		for(Beauty beauty : beauties) {
			System.out.println(beauty);
		}
	}

	/**
	 * list.clone()，当list里放的是对象等引用类型，是浅拷贝
	 */
	public void m2(){

		List<Beauty> list1=new ArrayList<>();
		list1.add(new Beauty("王昭君", 5, 86.25));
		list1.add(new Beauty("赵飞燕", 6, 76.25));
		list1.add(new Beauty("陈圆圆", 7, 56.25));
		list1.add(new Beauty("杨玉环", 8, 66.25));
		list1.add(new Beauty("苏妲己", 9, 96.25));

		List<Beauty> list2=new ArrayList<>();
		list2 = (List<Beauty>) ((ArrayList<Beauty>) list1).clone();

		//修改list1  索引为0的对象name字段
		list1.get(0).setName("洛神甄氏");

		for(Beauty beauty : list1) {
			System.out.println("1=====list1:"+beauty);
		}

		for(Beauty beauty : list2) {
			System.out.println("2========"+beauty);
		}
	}

	/**
	 *CollectionUtils.addAll()+Collections.copy()同样是浅拷贝
	 */
	public void m3(){
		List<Beauty> list1=new ArrayList<>();
		list1.add(new Beauty("王昭君", 5, 86.25));
		list1.add(new Beauty("赵飞燕", 6, 76.25));
		list1.add(new Beauty("陈圆圆", 7, 56.25));
		list1.add(new Beauty("杨玉环", 8, 66.25));
		list1.add(new Beauty("苏妲己", 9, 96.25));

		List<Beauty> list2=new ArrayList<>();
		CollectionUtils.addAll(list2, new Object[list1.size()]);
		Collections.copy(list2,list1);

		//修改list1  索引为0的对象name字段
		list1.get(0).setName("洛神甄氏");

		for(Beauty beauty : list1) {
			System.out.println("1=====list1:"+beauty);
		}

		for(Beauty beauty : list2) {
			System.out.println("2========"+beauty);
		}
	}

	public void m4() throws IOException, ClassNotFoundException {
		List<Beauty> list1=new ArrayList<>();
		list1.add(new Beauty("王昭君", 5, 86.25));
		list1.add(new Beauty("赵飞燕", 6, 76.25));
		list1.add(new Beauty("陈圆圆", 7, 56.25));
		list1.add(new Beauty("杨玉环", 8, 66.25));
		list1.add(new Beauty("苏妲己", 9, 96.25));


		List<Beauty> list2 = deepCopy(list1);

		//修改list1  索引为0的对象name字段
		list1.get(0).setName("洛神甄氏");

		for(Beauty beauty : list1) {
			System.out.println("1=====list1:"+beauty);
		}

		for(Beauty beauty : list2) {
			System.out.println("2========"+beauty);
		}
	}

	public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(byteOut);
		out.writeObject(src);

		ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
		ObjectInputStream in = new ObjectInputStream(byteIn);
		@SuppressWarnings("unchecked")
		List<T> dest = (List<T>) in.readObject();
		return dest;
	}
}
