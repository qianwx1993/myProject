package com.qwx.myProject.util.factory;

import org.dom4j.io.SAXReader;
import org.dom4j.*;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.lang.reflect.Method;

/**
 * @author Qian
 * @Version 1.0
 * @Since JDK1.8
 * @Company Bangsun
 * @Date 2020/11/3 15:41
 */
public class ConcreteBeanFactory implements BeanFactory{
	private Map<String, Object> beanDefinitionMap = new HashMap<String, Object>();


	//简单工厂模式的特征是：一个工厂中可以生产多种不同的产品，这里的Bean其实是没有区分不同的bean，是可以通过get返回不同的bean
	@Override
	public Object getBean(String beanName) {
		return beanDefinitionMap.get(beanName);
	}


	//增加一个init的操作方法

	//从xml配置文件中进行解析读取

	public void init(String xmlPath){

		SAXReader saxReader = new SAXReader();
		File file = new File(xmlPath);
		try {
			Document document = saxReader.read(file);
			Element root = document.getRootElement();
			Element foo;
			// 遍历bean
			for (Iterator i = root.elementIterator("bean"); i.hasNext();) {
				foo = (Element) i.next();
				// 获取bean的属性id和class
				Attribute id = foo.attribute("id");
				Attribute cls = foo.attribute("class");
				// 利用Java反射机制，通过class的名称获取Class对象
				Class<?> bean = Class.forName(cls.getText());
				// 获取对应class的信息
				java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
				// 获取其属性描述
				java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
				// 设置值的方法
				Method mSet = null;
				// 创建一个对象
				Object obj = bean.newInstance();
				// 遍历该bean的property属性
				for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {
					Element foo2 = (Element) ite.next();
					// 获取该property的name属性
					Attribute name = foo2.attribute("name");
					String value = null;
					Object typeValue = null;
					//获取value值
					value = foo2.attributeValue("value");
					for (int k = 0; k < pd.length; k++) {
						if (pd[k].getName().equalsIgnoreCase(name.getText())) {
							mSet = pd[k].getWriteMethod();
							//设置值这里，需要根据类型给value做类型转换
							//properties中包含了properType的项，因为当前程序中就只有String和Int，先处理这样的类型
							Type mType = pd[k].getPropertyType();
							if (mType.getTypeName().equals("java.lang.String")){
								typeValue = String.valueOf(value);
							}
							else if(mType.getTypeName().equals("int")){
								typeValue = Integer.parseInt(value);
							}
							mSet.invoke(obj, typeValue);
						}
					}
				}
				// 将对象放入beanMap中，其中key为id值，value为对象
				beanDefinitionMap.put(id.getText(), obj);
			}
		}catch (Exception e){
			System.out.println(e.toString());
		}

	}
}
