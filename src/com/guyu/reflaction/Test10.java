package com.guyu.reflaction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Des 分析性能问题
 * @Author guyu
 * @Date 2020/3/28 15:23
 * @Param
 * @Return
 */
public class Test10 {
    //普通方式调用
    public static  void test(){
        User user=new User();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("普通方法执行10亿次需要的时间："+(endTime-startTime)+"ms");


    }
    //反射方式调用 关闭检测
    public static  void test01() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user=new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);


        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式执行10亿次需要的时间："+(endTime-startTime)+"ms");

    }
    //反射方式调用
    public static  void test02() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user=new User();
        Class c1 = user.getClass();

        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("反射方式关闭检测执行10亿次需要的时间："+(endTime-startTime)+"ms");

    }

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        test();
        test01();
        test02();
        /*
        测试结果
        普通方法执行10亿次需要的时间：3ms
反射方式执行10亿次需要的时间：2939ms
反射方式关闭检测执行10亿次需要的时间：1327ms
         */
    }
}
