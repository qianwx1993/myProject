package com.qwx.myProject.aspect;

import com.alibaba.fastjson.JSONObject;
import com.qwx.myProject.annotaiton.SetValue;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2021/1/26 23:58
 */
@Slf4j
@Aspect
@Component
public class SetFieldValueAspect {
    @Autowired
    private ApplicationContext context;
    @AfterReturning(value = "@annotation(com.qwx.myProject.annotaiton.NeedSetFieldValue)",returning = "ret")
    public Object doSetFieldValue(JoinPoint point,Object ret) throws Exception {
        //设置值
        if (ret instanceof Collection){
            setFieldValueForCollection((Collection) ret);
        }else {
            setFieldValueForCollection((Arrays.asList(ret)));
        }
        return JSONObject.toJSONString(ret);
        //
    }

    private void setFieldValueForCollection(Collection coll) throws Exception {
        if (CollectionUtils.isEmpty(coll)){
            return;
        }
        //设置元素的属性值
        //1.得到设置信息——Order
        Class<?> clazz = coll.iterator().next().getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field needSetField : fields) {
            //获取@SetValue注解
            SetValue sv = needSetField.getAnnotation(SetValue.class);
            if (sv==null){
                continue;
            }
            //要调用的bean 方法 ，参数来源
            Class<?> aClass = sv.beanClass();
            //UserService.class
            Object bean = this.context.getBean(aClass);
            Field paramField = clazz.getDeclaredField(sv.paramField());
            Method method = sv.beanClass().getMethod(sv.method(), paramField.getType());

            //设置该字段可以暴力访问
            paramField.setAccessible(true);

            Field targetField=null;
            for (Object obj : coll) {
                //custId
                Object paramValue = paramField.get(obj);
                if (paramValue==null){
                    continue;
                }
                //username
                Object value = method.invoke(bean, paramValue);
                if (value!=null && sv.targetField() !=null){
                    if (targetField==null){
                        targetField = value.getClass().getDeclaredField(sv.targetField());
                        targetField.setAccessible(true);
                    }
                    value=targetField.get(value);
                }
                //设置字段的值
                needSetField.setAccessible(true);
                needSetField.set(obj,value);
            }
        }
    }
}
