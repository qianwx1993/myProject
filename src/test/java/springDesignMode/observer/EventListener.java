package springDesignMode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现监听者接口
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/9 21:16
 */
public class EventListener  implements Listener{
    private List<Observer> events = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer object) {
        events.add(object);
    }
    @Override
    public void removeObserver(Observer observer) {
        events.remove(observer);
    }
    @Override
    public void notifyObserver(String message) {
        for (Observer observer : events) {
            Event event = Event.builder()
                        .source(this)
                        .target(observer)
                        .message(message)
                        .time(System.currentTimeMillis())
                        .build();
            observer.operation(event);
        }
    }
}
