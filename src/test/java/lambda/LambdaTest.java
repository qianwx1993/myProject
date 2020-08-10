package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 匿名内部类写法
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/10 15:28
 */
public class LambdaTest {
	/**
	 * 无参函数的简写
	 * JDK1.7匿名内部类写法
	 */
	@Test
	public void test1() {
		new Thread(new Runnable(){// 接口名
			@Override
			public void run(){// 方法名
				System.out.println("Thread run()");
			}
		}).start();
	}

	/**
	 * 无参函数的简写
	 * JDK1.8匿名内部类写法
	 *Lambda 表达式在 Java 语言中引入了一个新的语法元素和操作符。这个操作符为 “->”，
	 * 该操作符被称 为 Lambda 操作符或箭头操作符。它将 Lambda 分为两个部分：
	 * 左侧：指定了 Lambda 表达式需要的所有参数
	 * 右侧：指定了 Lambda 体，即 Lambda 表达式要执行的功能。
	 */
	@Test
	public void test2(){
		new Thread(
				() -> System.out.println("JDK1.8：Thread run()")
		).start();
	}

	/**
	 * 无参函数的简写
	 *接上：JDK1.8匿名内部类写法
	 * 如果函数体有多行，可以用大括号括起来
	 */
	@Test
	public void test3(){
		new Thread(
				() -> {
					System.out.println("hello_1");
					System.out.println("hello_2");
				}
		).start();
	}

	/**
	 *带参函数的简写
	 * JDK1.7写法
	 */
	@Test
	public void test4(){
// JDK7 匿名内部类写法
		List<String> list = Arrays.asList("I", "love", "you", "too");
		Collections.sort(list, new Comparator<String>(){// 接口名
			@Override
			public int compare(String s1, String s2){// 方法名
				if(s1 == null)
					return -1;
				if(s2 == null)
					return 1;
				return s1.length()-s2.length();
			}
		});
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println();
	}

	/**
	 * 带参函数的简写
	 * 除了省略了接口名和方法名，代码中把参数表的类型也省略了。
	 *
	 * 得益于javac的类型推断机制，编译器能够根据上下文信息推断出参数的类型，
	 * 当然也有推断失败的时候，这时就需要手动指明参数类型了。注意，Java是强类型语言，每个变量和对象都必需有明确的类型。
	 *
	 */
	@Test
	public void test5(){
		List<String> list = Arrays.asList("I", "love", "you", "too");
		Collections.sort(list,(s1,s2) -> {
			if(s1 == null)
				return -1;
			if(s2 == null)
				return 1;
			return s1.length()-s2.length();
		});
	}
}
