package com.qwx.copy.clone;/**
 * @Auther: qian
 * @Date: 2020/3/3 22:17
 * @Company qian
 * @Description:
 */

import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 22:17
 */
@Data
public class Course implements Cloneable{
    private String name;
    private Integer id;
    @Override
    public String toString() {
        return "Course [name=" + name + ", id=" + id + "]";
    }
    @Override
    protected Course clone() throws CloneNotSupportedException{
        return (Course)super.clone();
    }
}
