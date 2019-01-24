package com.qwx.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  第四步：使用线程工厂创建线程池，并调用其execute方法
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/25 0:52
 */
public class ThreadExceptionUncaughtExceptionHandler {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool(new HanlderThreadFactory());
        exec.execute(new ExceptionThread());
    }
}
