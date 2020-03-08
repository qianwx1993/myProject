package thread;

import java.util.concurrent.ThreadFactory;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/8 21:39
 */
public class DiyThreadFactory implements ThreadFactory{
    int sum=0;
    @Override
    public Thread newThread(Runnable r) {
        sum++;
        return new Thread("diy-Thread-name:"+sum);
    }
}
