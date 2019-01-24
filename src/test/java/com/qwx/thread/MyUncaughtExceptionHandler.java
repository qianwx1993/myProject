package com.qwx.thread;

/**
 * 第一步：定义符合线程异常处理器规范的“异常处理器”
 * 实现Thread.UncaughtExceptionHandler规范
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/25 0:35
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    /*
     * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时被调用
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获    "+e);
    }
}
