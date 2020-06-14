package com.guyu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Des 自定义注解
 * @Author guyu
 * @Date 2020/3/28 8:44
 * @Param
 * @Return
 */
public class Test03 {

    //顺序无关，，没有默认参数赋值的，必须手动赋值，有默认赋值的可以不用去管
    @MyAnnotation2(schools = {"北京工业大学","北工大"},name="谷雨")
    //当参数名为value时，并且只有一个value参数，value可以省略。
    @MyAnnotation3("谷雨")
    public void test01(){

    }
}
//一般注解不会这么复杂
//作用范围
@Target({ElementType.TYPE,ElementType.METHOD})
//作用周期
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数格式 ：参数类型+参数名(); *******一定要有括号和分号
    //String name();  不带默认值的情况
    String name() default "";//带默认值的情况
    int age() default 0;
    int id() default -1;    //默认值为-1，代表不存在，和indexof有相同的规则，如果没有返回-1；

    String[] schools();     //也可以定义数组

}
//作用范围
@Target({ElementType.TYPE,ElementType.METHOD})
//作用周期
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //注解的参数格式 ：参数类型+参数名(); *******一定要有括号和分号
   String value();

}


