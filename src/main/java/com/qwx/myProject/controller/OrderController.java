package com.qwx.myProject.controller;

import com.qwx.myProject.model.Order;
import com.qwx.myProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/1/26 23:35
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/query")
    public List<Order> queryOrder(){
        return orderService.query();
    }
}
