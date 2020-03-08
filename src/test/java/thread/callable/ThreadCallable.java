package thread.callable;

import java.util.concurrent.Callable;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/8 16:53
 */
public class ThreadCallable implements Callable<Integer>{
    private int num;
    private int num1;
    public ThreadCallable(int num, int num1) {
        this.num = num;
        this.num1 = num1;

    }
    @Override
    public Integer call() throws Exception {
        int sum = num/num1;
        System.out.println("线程t的运算结果：" + sum);
        return sum;
    }
}
