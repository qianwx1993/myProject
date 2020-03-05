package thread;/**
 * @Auther: qian
 * @Date: 2020/3/5 22:51
 * @Company qian
 * @Description:
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/5 22:51
 */
public class ThreadDoneTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadDoneTest threadPoolDemo = new ThreadDoneTest();

        ExecutorService exe = Executors.newFixedThreadPool(50);
        for (int i = 1; i <= 5; i++) {
            ThreadDemo threadDemo = threadPoolDemo.new ThreadDemo();
            exe.execute(threadPoolDemo.new ThreadDemo());
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
            Thread.sleep(200);
        }
    }

    class ThreadDemo implements Runnable{
        public void run()
        {
            System.err.println("hello world");
        }

    }
}
