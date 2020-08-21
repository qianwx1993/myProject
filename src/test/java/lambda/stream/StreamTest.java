package lambda.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}
