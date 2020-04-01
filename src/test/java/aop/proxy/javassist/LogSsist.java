package aop.proxy.javassist;

import aop.proxy.BarService;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;

/**
 * Javassist实现aop
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/15 23:41
 */
public class LogSsist {
    public static Class enhanceClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();

        //获取目标类
        CtClass targetClass = classPool.getCtClass("aop.proxy.BarServiceImp");

        //获取织入的连接点
        CtMethod doSomething = targetClass.getDeclaredMethod("doSomething");

        //织入增强代码，这里会重新加载字节码
        doSomething.insertBefore("System.out.println(\"33333======执行AOP织入的代码!!!\");");

        return targetClass.toClass();
    }

    public static void main(String[] args) throws Exception {
        Class clazz = enhanceClass();

        BarService service = (BarService) clazz.newInstance();
        service.doSomething();
    }
}
