package thread;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/8 21:48
 */
public class ThreadDemo implements Runnable{
    @Override
    public void run() {
        System.err.println("hello world");
        System.err.println(Thread.currentThread().getName());
    }
}
