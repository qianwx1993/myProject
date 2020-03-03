package com.qwx.copy.clone;/**
 * @Auther: qian
 * @Date: 2020/3/3 22:44
 * @Company qian
 * @Description:
 */

import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 22:44
 */
@Data
public class Book implements Cloneable{
    public String name;
    public StringBuffer author;
    @Override
    protected Book clone() throws CloneNotSupportedException{
        return (Book)super.clone();
    }
}
