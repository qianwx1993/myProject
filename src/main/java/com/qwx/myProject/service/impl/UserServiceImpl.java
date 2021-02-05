package com.qwx.myProject.service.impl;

import com.qwx.myProject.pojo.User;
import com.qwx.myProject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/1/26 23:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User selectById(Integer id) {
        User user=null;
        if (1==id) {
            user= new User(1, "钱多多", null, 20);
        } if (2==id) {
            user = new User(1, "青青", null, 21);
        } if (3==id) {
            user = new User(1, "熊飞", null, 22);
        }
        return user;
    }
}
