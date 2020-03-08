package thread.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @author Qian
 * @Company Bangsun
 * @Date 2020/3/7 21:59
 */
public class TestSchedule {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //1s后跑，只跑一次
        scheduledExecutorService.schedule(new PrintTask("1"),1, TimeUnit.SECONDS);
        //第一次隔5s，之后隔1s；注意，时间间隔为任务开启时计算；
        //当任务跑的时间大于时间间隔，下次任务推迟到任务跑完再执行。
        scheduledExecutorService.scheduleAtFixedRate(new PrintTask("2"),5,1,TimeUnit.SECONDS);
        //第一次隔5s，之后隔1s；注意，时间间隔从上次任务时跑完计算；
        //当任务跑的时间大于时间间隔，下次任务推迟到任务跑完再执行。
        scheduledExecutorService.scheduleWithFixedDelay(new PrintTask("3"),5,1,TimeUnit.SECONDS);

    }
}
