package com.qwx.thread.interrupt;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/5/23 15:32
 */
public class InterruptionInJava implements Runnable{
	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Yes!!  I'm Interupted,  but I'm still running");
				return;
			} else {

			}
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new InterruptionInJava(), "testThread");
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		System.out.println("Begin Interupt...");
		thread.interrupt();
		System.out.println("End Interupt...");
	}
}
