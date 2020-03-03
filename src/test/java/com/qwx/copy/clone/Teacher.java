package com.qwx.copy.clone;/**
 * @Auther: qian
 * @Date: 2020/3/3 22:16
 * @Company qian
 * @Description:
 */

import lombok.Data;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 22:16
 */
@Data
public class Teacher implements Cloneable{
    private String name;
    private Integer age;
    private Course course;

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        Teacher teacher = (Teacher) super.clone();
        teacher.course=course.clone();
        return teacher;
    }
    @Override
    public String toString() {
        return "Teacher [name=" + name + ", age=" + age + ", course=" + course + "]";
    }
}
