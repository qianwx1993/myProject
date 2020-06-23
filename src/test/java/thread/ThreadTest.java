package thread;

import java.util.concurrent.*;

/**
 * 为什么execute方法后，线程并没有跑
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/8 21:42
 */
public class ThreadTest {
    //新建线程池，使用diyThreadFactory
    public static void main(String[] args) throws InterruptedException {
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10), new DiyThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
//        ExecutorService threadPoolExecutor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            threadPoolExecutor.execute(new ThreadDemo());
        }
        threadPoolExecutor.shutdown();*/
        /*while (true) {
            if (threadPoolExecutor.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
            Thread.sleep(200);
        }*/
    }
}
