package com.qwx.myProject.service.impl;

import com.qwx.myProject.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/4/2 0:19
 */
@Service
public class RedisService {
    @Autowired //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    private StringRedisTemplate stringRedisTemplate;
    @Autowired  // RedisTemplate，可以进行所有的操作
    private RedisTemplate<Object,Object> redisTemplate;

    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void set(Student s){
        redisTemplate.opsForValue().set(s.getId(), s);
    }

    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public Student getStudent(String key){
        return (Student) redisTemplate.opsForValue().get(key);
    }
}
