package springDesignMode.observer;

import lombok.Builder;
import lombok.Data;

/**
 * 定义通知回调格式
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/9 21:04
 */
@Data
@Builder
public class Event {
    /**
     * 事件源
     */
    private Object source;
    /**
     * 通知目标
     */
    private Object target;
    /**
     * 监听事件
     */
    private String message;
    /**
     * 事件时间
     */
    private long time;
}
