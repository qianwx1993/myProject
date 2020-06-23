package com.redis.sentinel;

import com.qwx.myProject.MyProjectApplication;
import com.qwx.myProject.pojo.Student;
import com.qwx.myProject.service.impl.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/4/2 0:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyProjectApplication.class)
public class SpringbootRedisApplicationTests {
    @Resource
    private RedisService service;

    @Test
    public void setKey(){
        service.set("test100","100");
        System.out.println("###"+service.get("test100"));
    }

    @Test
    public void contextLoads() {
        service.set("myname", "chhliu");
        Student s = new Student();
        s.setId(1);
        s.setName("chhliu");
        s.setAge(22);
        service.set(s);

        String name = service.get("myname");
        System.out.println("name:"+name);

        Student stu = service.getStudent("001");
        System.out.println(stu);
    }
}
