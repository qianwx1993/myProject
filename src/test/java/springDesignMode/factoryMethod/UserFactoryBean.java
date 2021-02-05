package springDesignMode.factoryMethod;

import com.qwx.myProject.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/4 20:34
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User(1,"cxq","123456",1);
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
