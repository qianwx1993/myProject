package thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static javafx.scene.input.KeyCode.L;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/8 16:52
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //submit与execute方法，效果一样的。都是提交到线程池
        Future<Integer> future = executorService.submit(new ThreadCallable(4, 2));
        Integer integer = future.get();
        System.out.println("submit返回值："+integer);

        System.out.println("是否完成："+executorService.isTerminated());
        System.out.println("线程是否关闭："+executorService.isShutdown());
        Thread.sleep(60*1000);
        executorService.shutdown();
        System.out.println("线程是否关闭："+executorService.isShutdown());
    }
}
