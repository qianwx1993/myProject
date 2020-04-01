package aop.proxy.jdk_proxy;

import aop.proxy.BarService;
import aop.proxy.BarServiceImp;

import java.lang.reflect.Proxy;

/**
 *jdk动态代理示例
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/15 22:22
 */
public class App {
    public static void main(String[] args) {
        BarService service = (BarService) Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(), new Class[]{BarService.class}, new LogPrintHandler(new BarServiceImp()));
        service.doSomething();
    }
}
