package aop.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 织入AOP逻辑，打印日志
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/15 22:21
 */
public class LogPrintHandler implements InvocationHandler {
    private Object target;

    public LogPrintHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行AOP织入的代码!!!");
        Object ret = method.invoke(this.target, args);
        return ret;
    }
}
