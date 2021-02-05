package com.qwx.myProject.annotaiton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: qian
 * @Date: 2021/1/26 23:54
 * @Company qian
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetValue {
    //注释
    //注释项
    //哪个属性需要我们设置值

    //调用哪个bean的哪个方法来设置值
    Class<?> beanClass();
    String method();

    //该传入哪个属性作为参数值
    String paramField();
    //需要取哪个属性
    String targetField();
}
