package com.qwx.myProject.model;

import com.qwx.myProject.annotaiton.SetValue;
import com.qwx.myProject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/1/26 23:36
 */
@Data
@AllArgsConstructor
public class Order implements Serializable {
    private Integer id;
    private Integer custId;
    @SetValue(beanClass = UserService.class,method = "selectById",paramField = "custId",targetField = "username")
    private String custName;
    private String prodName;
    private Integer price;
}
