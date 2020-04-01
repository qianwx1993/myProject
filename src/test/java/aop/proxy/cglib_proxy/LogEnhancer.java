package aop.proxy.cglib_proxy;

import aop.proxy.BarService;
import aop.proxy.BarServiceImp;
import org.assertj.core.internal.cglib.proxy.Enhancer;
import org.assertj.core.internal.cglib.proxy.MethodInterceptor;
import org.assertj.core.internal.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib代理示例
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/15 23:22
 */
public class LogEnhancer {
    private static class MyCallback implements MethodInterceptor {
        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("222=====执行AOP织入的代码!!!");
            Object ret = proxy.invokeSuper(obj, args);

            return ret;
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BarServiceImp.class);
        enhancer.setCallback(new MyCallback());

        BarService service = (BarService) enhancer.create();
        service.doSomething();
    }
}
