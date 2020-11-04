package springDesignMode.factoryMethod;

import com.qwx.myProject.pojo.User;

/**
 * 工厂方法——实例工厂方法
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/4 9:21
 */
public class UserInstaceFactory {
	public User getUser(String name) {
		System.out.println("实例工厂造人...");
		User user = new User();
		user.setUsername(name);
		user.setPassWord("123456");
		user.setAge(1);
		return user;
	}
}
