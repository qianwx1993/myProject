package springDesignMode.observer;

public interface Listener {
    /**
     * 注册观察者
     * @param object
     */
    public void registerObserver(Observer object);

    /**
     * 删除观察者
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message 通知消息
     */
    public void notifyObserver(String message);
}
