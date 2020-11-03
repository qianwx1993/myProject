package springDesignMode.factoryMethod;

import com.qwx.myProject.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 工厂方法-静态工厂方法 客户端
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/4 0:00
 */
public class StaticFactoryMethodClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("static-factory-bean.xml");
        User u = (User) ctx.getBean("qwx");
        System.out.println(u);

        User u2 = (User) ctx.getBean("cxq");
        System.out.println(u2);
    }
}
