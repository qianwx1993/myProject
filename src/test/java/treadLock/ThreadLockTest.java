package treadLock;

/**
 * 上边是ThreadLocal的一个使用demo，需要处理的细节是：ThreadLocal使用完后，需要调用remove清除当前线程的变量副本，
 * 否则，会产生内存溢出，如果是使用线程池，由于线程是共享的，还会为其他任务留下脏数据。
 * @author Qian
 * @Version 1.0
 * @Date 2021/4/7 17:50
 */
public class ThreadLockTest {
    static ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1=new Thread(){
            @Override
            public void run() {
                threadLocal.set("1");
                System.out.println("#threadLocal1="+threadLocal.get());
                threadLocal.remove();
            }
        };

        Thread thread2=new Thread(){
            @Override
            public void run() {
                threadLocal.set("2");
                System.out.println("threadLocal2="+threadLocal.get());
                threadLocal.remove();
            }
        };

        thread1.start();
        thread2.start();
    }

}
