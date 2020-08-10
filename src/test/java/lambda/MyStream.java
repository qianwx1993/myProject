package lambda;

import lombok.Data;

import java.util.List;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/10 17:15
 */
@Data
public class MyStream<T> {
	private List<T> list;

	public void myForEach(ConsumerInterface<T> consumer){// 1
		for(T t : list){
			consumer.accept(t);
		}
	}

	public static void main(String[] args) {
		MyStream<String> stream = new MyStream<String>();
		// 使用自定义函数接口书写Lambda表达式
		stream.myForEach(str -> System.out.println(str));
	}
}
