package com.qwx.myProject.annotaiton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: qian
 * @Date: 2021/1/26 23:52
 * @Company qian
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedSetFieldValue {
}
