package com.qwx.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/5/23 23:49
 */
public class InterruptDemo02 implements Runnable{
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){ //false
			try {
				TimeUnit.SECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("###"+Thread.currentThread().isInterrupted());
				//可以不做处理，
				//继续中断 ->
				Thread.currentThread().interrupt(); //再次中断
				//抛出异常。。
			}
		}
		System.out.println("processor End");
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new InterruptDemo02());
		t1.start();
		Thread.sleep(1000);
		t1.interrupt(); //有作用 true
		Thread.interrupted() ;//复位
	}
}
