package com.qwx.myProject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.annotaiton.NeedSetFieldValue;
import com.qwx.myProject.model.Order;
import com.qwx.myProject.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/1/27 0:02
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    static List<Order> list=new ArrayList<>();
    static {
        Order order=new Order(1,1,null,"小米手机",10000);
        Order order1=new Order(1,2,null,"苹果手机",20000);
        Order order2=new Order(1,3,null,"华为",30000);
        list.add(order);
        list.add(order1);
        list.add(order2);
    }
    @Override
    @NeedSetFieldValue
    public List<Order> query() {
        log.info("初始order数据:{}", JSONObject.toJSONString(list));
        return list;
    }
}
