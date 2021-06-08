package com.qwx.thread.interrupt;

/**
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/5/23 17:14
 */
public class InterruptJoinTest {
	public static void main(String... args) {
		T1 t1 = new T1();
		T2 t2 = new T2(t1);

		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		t2.interrupt();
	}
}

class T1 extends Thread {

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "======" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

class T2 extends Thread {
	private T1 t;
	public T2(T1 t) {
		this.t = t;
	}

	public void run() {
		try {
			t.join();
			System.out.println(Thread.currentThread().getName() + "######");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(Thread.currentThread().getName() + "$$$$$$$$$$$$$$$" + Thread.currentThread().isInterrupted());
		}
	}
}
