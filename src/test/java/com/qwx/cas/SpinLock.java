package com.qwx.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Version 1.0
 * @Since JDK1.8
 * @Author Qian
 * @Company Bangsun
 * @Date 2019/10/10 21:43
 */
public class SpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<>();

	public void lock(){
		Thread currentThread = Thread.currentThread();
		while(!owner.compareAndSet(null, currentThread)){  // owner == null ，则compareAndSet返回true，否则为false。
			//拿不到owner的线程，不断的在死循环
		}
	}

	public void unLock(){
		owner.set(null);
		// 也可以这样写，太麻烦，没必要
        /*
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
         */
	}
}
