package aop.proxy;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/15 22:21
 */
public class BarServiceImp implements BarService {
    @Override
    public void doSomething() {
        System.out.println("执行原有业务逻辑...");
    }
}
