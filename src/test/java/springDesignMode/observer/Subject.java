package springDesignMode.observer;

/**
 * 实现观察者与监听者关联
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/9 21:17
 */
public class Subject {
    Listener listener;

    public Subject(Listener listener) {
        this.listener = listener;
    }

    public void sendMsg(String msg){
        System.out.println(msg);
        listener.notifyObserver(msg);
    }

    public void sendBlog(String blog){
        System.out.println(blog);
        listener.notifyObserver(blog);
    }
}
