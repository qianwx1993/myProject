package lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/17 10:33
 */
public class StreamTest {
	public List<Student> initList(){
		Student stuA = new Student(1, "A", "M", 184);
		Student stuB = new Student(2, "B", "G", 163);
		Student stuC = new Student(3, "C", "M", 175);
		Student stuD = new Student(4, "D", "G", 158);
		Student stuE = new Student(5, "E", "M", 170);
		List<Student> list = new ArrayList<>();
		list.add(stuA);
		list.add(stuB);
		list.add(stuC);
		list.add(stuD);
		list.add(stuE);
		return list;
	}

	/**
	 *stream初体验
	 */
	@Test
	public void test1(){
		List<Student> list = initList();
		list.stream().filter(student -> "G".equals(student.getSex()))
				.forEach(student -> System.out.println(student.toString()));
	}

	/**
	 * distinct()，作用是返回一个去除重复元素之后的Stream。
	 */
	@Test
	public void test2(){
		Stream<String> stream= Stream.of("I", "love", "you", "too", "too");
		stream.distinct()
				.forEach(str -> System.out.println(str));
	}

	@Test
	public void test3(){
		Stream<String> stream= Stream.of("I", "love", "you", "too");
		stream.sorted((str1, str2) -> str1.length()-str2.length())
				.forEach(str -> System.out.println(str));
	}

	/**
	 * map()
	 * 作用是返回一个对当前所有元素执行执行mapper之后的结果组成的Stream。
	 * 直观的说，就是对每个元素按照某种操作进行转换，转换前后Stream中元素的个数不会改变，
	 * 但元素的类型取决于转换之后的类型
	 */
	@Test
	public void test4(){
		Stream<String> stream= Stream.of("I", "love", "you", "too");
		stream.map(str -> str.toUpperCase())
				.forEach(str -> System.out.println(str));
	}
	/**
	 * flatMap()
	 * 作用是对每个元素执行mapper指定的操作，并用所有mapper返回的Stream中的元素组成一个新的Stream作为
	 * 最终返回结果。说起来太拗口，通俗的讲flatMap()的作用就相当于把原stream中的所有元素都”摊平”之后组成的Stream，
	 * 转换前后元素的个数和类型都可能会改变。
	 */
	@Test
	public void test5(){
		/*
		*原来的stream中有两个元素，分别是两个List<Integer>，执行flatMap()之后，
		*将每个List都“摊平”成了一个个的数字，所以会新产生一个由5个数字组成的Stream。
		*所以最终将输出1~5这5个数字
		 */
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
		stream.flatMap(list -> list.stream())
				.forEach(i -> System.out.println(i));
	}
}
