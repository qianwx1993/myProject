package thread.schedule;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/3/7 22:03
 */
public class PrintTask implements Runnable {
    private String s;
    public PrintTask(String s) {
        this.s = s;
    }
    @Override
    public void run() {
        System.out.println(s);
    }
}
