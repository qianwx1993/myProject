package lambda.stream;

import lombok.Data;
import lombok.ToString;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/17 10:32
 */
@Data
@ToString
public class Student {
	int no;
	String name;
	String sex;
	float height;

	public Student(int no, String name, String sex, float height) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.height = height;
	}

}
