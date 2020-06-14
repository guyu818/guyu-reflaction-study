package com.guyu.reflaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Des 获取类运行的时候的结构
 * @Author guyu
 * @Date 2020/3/28 14:21
 * @Param 
 * @Return 
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //获取到类
        Class c1 = Class.forName("com.guyu.reflaction.User");

        //获取类的名字
        System.out.println(c1.getName());       //包名+类名
        System.out.println(c1.getSimpleName());//类名

        //获得类的属性
        System.out.println("======================================");
        Field[] fields = c1.getFields();        //只能找到public的属性

        fields=c1.getDeclaredFields();          //都可以获得，无论是public还是private
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定的属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("=======================================");
        Method[] methods = c1.getMethods();     //获得本类及其父类的全部的public方法
        for (Method method : methods) {
            System.out.println("正常的"+method);
        }

        methods= c1.getDeclaredMethods();       //获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods"+method);
        }

        //获得指定的方法
        //相应的参数一定要对应好了
        Method method = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(method);
        System.out.println(setName);

        //获取指定的构造器
        System.out.println("=================================");
        Constructor[] constructors = c1.getConstructors();      //获取public的构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        constructors = c1.getDeclaredConstructors();            //获取所有的构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        //获得指定的构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定的构造器"+declaredConstructor);




    }
}
