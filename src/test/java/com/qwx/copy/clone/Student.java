package com.qwx.copy.clone;/**
 * @Auther: qian
 * @Date: 2020/3/3 21:59
 * @Company qian
 * @Description:
 */

import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 21:59
 */
@Data
public class Student implements Cloneable{
    private String name;
    private String gender;

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
    @Override
    public String toString() {
        return " [name=" + name + ", gender=" + gender + "]";
    }
}
