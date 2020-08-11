package lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * list 新方法
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/11 10:28
 */
public class ListLambdaTest {

	/**
	 * Java7及以前我们可以用增强的for循环实现：
	 */
	@Test
	public void test1(){
		// 使用曾强for循环迭代
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		for(String str : list){
			if(str.length()>3)
				System.out.println(str);
		}
	}

	/**
	 * 现在使用forEach()方法结合匿名内部类，可以这样实现：
	 */
	@Test
	public void test2(){
		// 使用forEach()结合匿名内部类迭代
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.forEach(new Consumer<String>(){
			@Override
			public void accept(String str){
				if(str.length()>3)
					System.out.println(str);
			}
		});
	}

	/**
	 * 使用forEach()结合Lambda表达式迭代
	 *
	 *代码给forEach()方法传入一个Lambda表达式，我们不需要知道accept()方法，
	 * 也不需要知道Consumer接口，类型推导帮我们做了一切。
	 */
	@Test
	public void test3(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.forEach(str -> {
			if (str.length()>3){
				System.out.println(str);
			}
		});
	}

	/**
	 *使用removeIf()方法结合匿名内部类
	 */
	@Test
	public void test4(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String str) {
				return str.length()>3;
			}
		});
		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 *使用removeIf()方法结合lambda
	 */
	@Test
	public void test5(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.removeIf(str -> str.length()>3 );

		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 * 使用匿名内部类实现
	 * 该方法签名为void replaceAll(UnaryOperator<E> operator)，作用是对每个元素执行operator指定的操作，
	 * 并用操作结果来替换原来的元素。其中UnaryOperator是一个函数接口，里面只有一个待实现函数T apply(T t)。
	 */
	@Test
	public void test6(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.replaceAll(new UnaryOperator<String>() {
			@Override
			public String apply(String s) {
				if (s.length()>3){
					return s.toUpperCase();
				}
				return s;
			}
		});

		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 * replaceAll Lambda表达式实现
	 */
	@Test
	public void test7(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.replaceAll(str ->{
			if (str.length()>3){
				return str.toUpperCase();
			}
			return str;
		});
		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 *sort()：匿名内部类
	 *照字符串长度增序对元素排序
	 */
	@Test
	public void test8(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 * sort()：lambda
	 * 可以直接使用List.sort()方法，结合Lambda表达式
	 */
	@Test
	public void test9(){
		ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
		list.sort((str1,str2) -> str1.length()-str2.length());

		for (String s : list) {
			System.out.println(s);
		}
	}

	/**
	 * spliterator()
	 * 该方法返回容器的可拆分迭代器
	 * Spliterator.trySplit()方法,将20000的数据,分割成4份,trySplit()方法有些像二分查找,将list集合切分为一半.
	 */
	@Test
	public void test10(){
		List<String> list = new ArrayList<>(1000);
		for (int i = 0; i < 20000; i++) {
			list.add("bery" + i);
		}
		//0~20000
		Spliterator<String> spliterator1 = list.spliterator();
		//spliterator1:0~10000 spliterator2:10001~20000
		Spliterator<String> spliterator2 = spliterator1.trySplit();
		//spliterator1:0~5000 spliterator2:10001~20000 spliterator3:5001~10000
		Spliterator<String> spliterator3 = spliterator1.trySplit();
		//spliterator1:0~5000 spliterator2:10001~15000 spliterator3:5001~10000 spliterator4:15001~20000
		Spliterator<String> spliterator4 = spliterator2.trySplit();

		MyThredIteratorThread<String> thread1 = new MyThredIteratorThread<>(spliterator1);
		MyThredIteratorThread<String> thread2 = new MyThredIteratorThread<>(spliterator2);
		MyThredIteratorThread<String> thread3 = new MyThredIteratorThread<>(spliterator3);
		MyThredIteratorThread<String> thread4 = new MyThredIteratorThread<>(spliterator4);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();

		while(true){
			if (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()){
				try {
					//如果线程没有结束,主线程就睡眠300ms,当所有线程都执行完成才会结束主程序
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				break;
			}
		}

		System.err.println("test END");

	}
	private static class MyThredIteratorThread <T> extends Thread {

		private final Spliterator<T> list;

		private MyThredIteratorThread(Spliterator<T> list) {
			this.list = list;
		}

		@Override
		public void run() {
			list.forEachRemaining(e -> System.out.println(Thread.currentThread().getName()+":"+e));
		}
	}

	}
