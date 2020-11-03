package springDesignMode;

import com.qwx.myProject.pojo.User;
import com.qwx.myProject.util.factory.ConcreteBeanFactory;

/**
 * spring简单工厂示例
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/3 15:52
 */
public class SimpleFactoryClient {
	public static void main(String[] args){
		ConcreteBeanFactory absbf = new ConcreteBeanFactory();
		absbf.init("D:\\WorkSpace\\IdeaProjects\\myProject\\src\\main\\resources\\springtest.xml");
		User user = (User)absbf.getBean("usertest");
		System.out.println("User类的bean有没有创建成功：" + user);
		System.out.println("属性值：" + user.getUsername() + "," + user.getPassWord() + "," + user.getAge());

	}
}
