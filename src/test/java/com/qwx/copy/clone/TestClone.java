package com.qwx.copy.clone;

/**
 * @Version 1.0
 * @Since JDK1.6
 * @Author Qian
 * @Company Bangsun
 * @Date 2020/3/3 22:02
 */
public class TestClone {
    public static void main(String[] args) {
//        m1();
          m2();
//            m3();
    }
    /**
     *1、实现对象的Cloneable接口
     *当对象的属性为基本类型或者String类型，可以理解为是深复制，但当对象的属性含有除基本类型或者String类型时，是浅复制。
     * @param
     */
    public static void m1(){
        Student student1 = new Student();
        student1.setName("钱多多");
        student1.setGender("Male");
        System.out.println("student1"+student1);

        try{
            Student student2 = student1.clone();
            System.out.println("Clone student2 from student1...");
            System.out.println("student2"+student2);
            System.out.println(student1.equals(student2));
            System.out.println("Alter student2...");
            student2.setName("曹雪芹");
            student2.setGender("Female");
            System.out.println("student1"+student1);
            System.out.println("student2"+student2);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    /**
     * 2、实现对象的Cloneable接口,
     *当对象的属性为基本类型或者String类型，可以理解为是深复制，但当对象的属性含有除基本类型或者String类型时，是浅复制。
     * 但是当满足以下条件，调用clone方法也可以实现深拷贝：
     * a.对象实现Cloneable接口，并重写clone方法；
     * b.对象的属性也实现Cloneable接口，并重写clone方法
     * c.对象重写的clone方法，内部需指定该属性对象使用该属性对象自己的clone方法
     */
    public static void m2(){
        Teacher t1 = new Teacher();
        t1.setName("钱");
        t1.setAge(22);
        Course c1 = new Course();
        c1.setName("数学");
        c1.setId(66);
        t1.setCourse(c1);
        System.out.println("teacher1"+t1);

        try{
            Teacher t2 = t1.clone();
            System.out.println("teacher2"+t2);
            t2.setName("曹");
            t2.setAge(18);
            //修改courese属性
            t2.getCourse().setName("英语");
            t2.getCourse().setId(88);
            System.out.println("teacher1"+t1);
            System.out.println("teacher2"+t2);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    /**
     * String、StringBuffer类
     */
    public static void m3(){
        Book book = new Book();
        book.name = new String("红楼梦");
        book.author = new StringBuffer("曹雪芹");
        System.out.println("Before clone book.name :"+book.name);
        System.out.println("Before clone book.author :"+book.author);
        Book book_clone = null;
        try{
            book_clone = (Book)book.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        book_clone.name = book_clone.name.substring(0,2);
        book_clone.author = book_clone.author.append(" 高鹗");
        System.out.println("\nAfter clone book.name :"+book.name);
        System.out.println("After clone book.author :"+book.author);
        System.out.println("\nAfter clone book_clone.name :"+book_clone.name);
        System.out.println("After clone book_clone.author :"+book_clone.author);
    }

}
