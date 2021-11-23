package com.qwx.beanAutoload1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置类 --- 用于加载importselector包内的Demo7对象
 * @author Qian
 * @Since JDK1.8
 * @Date 2021/11/23 23:47
 */
@ComponentScan("com.qwx.beanAutoload1.demo")
@Configuration
public class HelloImportSelectorConfiguration {
}
