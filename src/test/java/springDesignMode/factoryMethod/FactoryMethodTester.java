package springDesignMode.factoryMethod;

import com.qwx.myProject.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/4 9:32
 */
public class FactoryMethodTester {
	/**
	 * 工厂方法-静态工厂方法 客户端
	 */
	@Test
	public void test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("static-factory-bean.xml");
		User u = (User) ctx.getBean("qwx");
		System.out.println(u);

		User u2 = (User) ctx.getBean("cxq");
		System.out.println(u2);
	}
	/**
	 * 工厂方法——实例工厂方法
	 */
	@Test
	public void testInstaceFacMethod(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("instance-factory-bean.xml");
		User user1 =(User) ctx.getBean("user1");
		System.out.println(user1);
	}
	@Test
	public void factoryBeanTest(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("user-factory-bean.xml");
		System.out.println("容器启动完成");
		Object bean = ctx.getBean("userFactoryBean");
		System.out.println("打印属性:" + bean);
	}
}

