package lambda;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/8/10 17:14
 */
@FunctionalInterface
public interface ConsumerInterface<T> {
	void accept(T t);
}
