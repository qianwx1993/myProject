package com.qwx.myProject.service;

import com.qwx.myProject.pojo.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User selectById(Integer id);
}
