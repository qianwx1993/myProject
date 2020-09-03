package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * lambda表达式中的this
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/11 9:17
 */
public class LambdaTest2 {
	private String name = "ThisDemo";

	/**
	 * lambda表达式最终会返回一个实现了指定接口的实例，看上去和内部匿名类很像，
	 * 但有一个最大的区别就是代码里面的this，内部匿名类this指向的就是匿名类，
	 * 而lambda表达式里面的this指向的当前类
	 */
	@Test
	public void test() {
		// 匿名类实现
		new Thread(new Runnable() {
			private String name = "Runnable";

			@Override
			public void run() {
				System.out.println("这里的this指向匿名类:" + this.name);
			}
		}).start();

		// lambda实现
		new Thread(() -> {
			System.out.println("这里的this指向当前的ThisDemo类:" + this.name);
		}).start();
	}

	/**
	 * Lambda表达式及匿名内部类 的作用域
	 * 注：lambda：不能更改非最终变量
	 * 如下：
	 *  s为局部变量，“s+=str;”代码更改了s的值，编译会不通过
	 */
	@Test
	public void test2() {
		String s="&";
		String[] arr={"1","2","3"};
		List<String> list=Arrays.asList(arr);
		list.forEach(str-> {
			//s+=str;//打开会报错
			System.out.println(s);
		});
		System.out.println(s);
	}

	public static void main(String[] args) {
		LambdaTest2 demo = new LambdaTest2();
		demo.test();
	}
}
