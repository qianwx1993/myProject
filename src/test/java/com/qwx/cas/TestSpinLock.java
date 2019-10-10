package com.qwx.cas;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/10/10 21:43
 */
public class TestSpinLock {
	final static int THREAD_NUM = 100;
	static int x = 0;

	@Test
	public void testLock() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(THREAD_NUM);

		// 锁
		final SpinLock spinLock = new SpinLock();
		for (int i = 0; i < THREAD_NUM; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// 每个线程循环多次，频繁上锁，解锁。
					for (int n = 0; n < 100; n++) {
						spinLock.lock();
						x++;
						//System.out.println(x);
						spinLock.unLock();
					}
					latch.countDown();    // 子线程通知主线程，工作完毕。
				}
			}).start();
		}

		System.err.println("最终："+x);    // 最终打印结果：10000 ，未出现线程不安全的异常。
	}
}
