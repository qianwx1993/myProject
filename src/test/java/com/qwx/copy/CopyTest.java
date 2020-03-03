package com.qwx.copy;/**
 * @Auther: qian
 * @Date: 2020/3/3 12:23
 * @Company Bangsun
 * @Description:
 */

import sun.misc.PostVMInitHook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 12:23
 */
public class CopyTest {
	public static void main(String[] args) {

	}

	public void m3(){
		List<String> list1=new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");

		Object[] arr1 = list1.toArray();
		String[] arr2=new String[list1.size()];

		List<String> list2=new ArrayList<>();
		System.arraycopy(arr1,0,arr2,0,list1.size());

		list2=Arrays.asList(arr2);
		for (String s : list2) {
			System.out.println("list2:"+s);
		}

		list1.remove(0);

		for (String s : list1) {
			System.out.println("1=========list1:"+s);
		}

		for (String s : list2) {
			System.out.println("2=========list2:"+s);
		}
	}

	public void m4(){
		List<String> list1=new ArrayList<>();
		list1.add("1");
		list1.add("2");
		list1.add("3");

		ArrayList<String> list2 = (ArrayList<String>) ((ArrayList<String>) list1).clone();

		list1.remove(0);

		for (String s : list1) {
			System.out.println("1=========list1:"+s);
		}

		for (String s : list2) {
			System.out.println("2=========list2:"+s);
		}
	}


}
