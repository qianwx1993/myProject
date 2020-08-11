package lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * map新方法
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/11 15:10
 */
public class MapLambdaTest {
	/**
	 *Map.forEach()结合匿名内部类
	 */
	@Test
	public void test(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.forEach(new BiConsumer<Integer, String>() {
			@Override
			public void accept(Integer k, String v) {
				System.out.println(k + "=" + v);
			}
		});
	}

	/**
	 *Map.forEach()结合lambda
	 */
	@Test
	public void test2(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}

	/**
	 * getOrDefault()——该方法跟Lambda表达式没关系，但是很有用
	 *Map查询Map中指定的值，不存在时使用默认值
	 *Java7以及之前做法
	 *
	 * jdk1.8 使用getOrDefault可以实现
	 */
	@Test
	public void test3(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		// Java7以及之前做法
		/*if(map.containsKey(4)){ // 1
			System.out.println(map.get(4));
		}else{
			System.out.println("NoValue");
		}*/
		// Java8使用Map.getOrDefault()
		System.out.println(map.getOrDefault(4, "NoValue")); // 2
	}

	/**
	 * putIfAbsent()-该方法跟Lambda表达式没关系，但是很有用
	 * 作用是只有在不存在key值的映射或映射值为null时.
	 * 该方法将条件判断和赋值合二为一，使用起来更加方便．
	 */
	@Test
	public void test4(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		map.putIfAbsent(3,"3");
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}

	/**
	 *remove()
	 *
	 * Map中有一个remove(Object key)方法，来根据指定key值删除Map中的映射关系.
	 * Java8新增了remove(Object key, Object value)方法，
	 * 只有在当前Map中key正好映射到value时才删除该映射，否则什么也不做．
	 */
	@Test
	public void test5(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		map.remove(3,"3");
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}

	/**
	 * 在Java7及以前，要想替换Map中的映射关系可通过put(K key, V value)方法实现，该方法总是会用新值替换原来的值．
	 * 为了更精确的控制替换行为，Java8在Map中加入了两个replace()方法，分别如下：
	 *
	 * replace(K key, V value)，只有在当前Map中key的映射存在时才用value去替换原来的值，否则什么也不做．
	 * replace(K key, V oldValue, V newValue)，只有在当前Map中key的映射存在且等于oldValue时才用newValue去替换原来的值，否则什么也不做．
	 */
	@Test
	public void test6(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		map.replace(4,"four");
		map.forEach((k,v)-> System.out.println(k + "=" + v));
		System.out.println("===============");

		map.replace(3,"three","3");
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}

	/**
	 *Java7以及之前替换所有Map中所有映射关系
	 */
	@Test
	public void test7(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		for(Map.Entry<Integer, String> entry : map.entrySet()){
			entry.setValue(entry.getValue().toUpperCase());
		}
	}

	/**
	 * 使用replaceAll()结合匿名内部类实现
	 *
	 * 该方法签名为replaceAll(BiFunction<? super K,? super V,? extends V> function)，
	 * 作用是对Map中的每个映射执行function指定的操作，并用function的执行结果替换原来的value，
	 * 其中BiFunction是一个函数接口，里面有一个待实现方法R apply(T t, U u)。
	 * 不要被如此多的函数接口吓到，因为使用的时候根本不需要知道他们的名字．
	 */
	@Test
	public void test8(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		map.replaceAll(new BiFunction<Integer, String, String>() {
			@Override
			public String apply(Integer integer, String s) {
				return s.toUpperCase();
			}
		});
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}

	/**
	 * 使用replaceAll()结合lambda表达式
	 */
	@Test
	public void test9(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");

		map.replaceAll((k,v)-> v.toUpperCase());
		map.forEach((k,v)-> System.out.println(k + "=" + v));
	}
}