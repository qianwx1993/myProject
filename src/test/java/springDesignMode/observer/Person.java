package springDesignMode.observer;

/**
 * 实现观察者接口
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/9 21:11
 */
public class Person implements  Observer{
    private String name;
    public Person(String name) {
        this.name = name;
    }
    @Override
    public void operation(Event event) {
        System.out.println(" 观察者 ： " + name + " 接收到信息 " + event.toString());
    }
}
