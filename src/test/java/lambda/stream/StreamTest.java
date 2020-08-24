package lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
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
	 * map
	 */
}
