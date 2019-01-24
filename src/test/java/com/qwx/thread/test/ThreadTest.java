package com.qwx.thread.test;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/1/25 0:18
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    try {
                        Thread.sleep(100);
                        System.out.println(i);
                        if (i==10){
                            throw new Exception(i+"");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("异常："+e.getMessage());
                    }
                }
            }
        }).start();
    }
}
