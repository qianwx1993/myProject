package springDesignMode.factoryMethod;

import java.util.HashMap;

/**
 * 单例-注册表
 * @author Qian
 * @Version 1.0
 * @Since JDK1.6
 * @Company Bangsun
 * @Date 2020/11/8 21:56
 */
public class RegSingleton {
    private static HashMap registry=new HashMap();
    //静态块，在类被加载时自动执行
    static{
        RegSingleton rs=new RegSingleton();
        registry.put(rs.getClass().getName(),rs);
    }
    //受保护的默认构造函数，如果为继承关系，则可以调用，克服了单例类不能为继承的缺点
    protected RegSingleton(){}
    //静态工厂方法，返回此类的唯一实例
    public static RegSingleton getInstance(String name){
        if(name==null){
            name="RegSingleton";
        }if(registry.get(name)==null){
            try{
                registry.put(name,Class.forName(name).newInstance());
            }catch(Exception ex){ex.printStackTrace();}
        }
        return (RegSingleton)registry.get(name);
    }
}
