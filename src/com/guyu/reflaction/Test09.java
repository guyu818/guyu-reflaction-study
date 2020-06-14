package com.guyu.reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Des 动态创建对象，通过反射
 * @Author guyu
 * @Date 2020/3/28 14:56
 * @Param 
 * @Return 
 */
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获取class对象
        Class c1 = Class.forName("com.guyu.reflaction.User");

        //方式1： 构造一个对象
//        User user = (User)c1.newInstance();     //只会调用默认的构造方法，如果没有默认的构造方法就报错
//        System.out.println(user);

        //方式2： 通过构造器创建对象，就可以使用有参的构造方法了
//        Constructor Constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User user2=(User)Constructor.newInstance("谷雨",001,18);
//        System.out.println(user2);

        //通过反射调用普通的方法
        User user3=(User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke ：激活
        //invoke(对象，“方法的值”）
        setName.invoke(user3,"谷大雨");
        System.out.println(user3.getName());

        //通过反射操作属性
        System.out.println("================================");
        User user4=(User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user4,"谷大雨");
        System.out.println(user4.getName());


    }
}
