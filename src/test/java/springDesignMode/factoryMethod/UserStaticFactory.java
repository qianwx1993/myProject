package springDesignMode.factoryMethod;

import com.qwx.myProject.pojo.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法-1.静态工厂方法
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/3 23:49
 */
public class UserStaticFactory {
    private static Map<String, User> map = new HashMap<String,User>();
    static{
        map.put("qwx", new User(1,"qwx","123456",10));
        map.put("cxq", new User(2,"cxq","123456",9));
        map.put("xf", new User(3,"xf","123456",10));
    }
    public static User getUser(String name){
        return map.get(name);
    }
}
