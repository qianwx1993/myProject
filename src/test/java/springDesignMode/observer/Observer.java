package springDesignMode.observer;

/**
 * 定义观察者接口
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/9 21:05
 */
public interface Observer {
    /**
     * 被观察的操作方法
     * @param event 操作打印日志
     */
    public void operation(Event event);
}
