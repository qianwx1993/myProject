package com.qwx.thread;

import java.util.concurrent.ThreadFactory;

/**
 * 第二步：定义线程工厂
 * 线程工厂用来将任务附着给线程，并给该线程绑定一个异常处理器
 * @Version 1.0
 * @Since JDK1.7
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/25 0:38
 */
public class HanlderThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"创建新线程");
        Thread t = new Thread(r);
        System.out.println("捕获 "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());//设定线程工厂的异常处理器
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        return t;
    }
}
