package com.guyu.annotation;

import java.lang.annotation.*;
import java.lang.annotation.Target;

/**
 * @Des 测试元注解
 * @Author guyu
 * @Date 2020/3/27 22:24
 * @Param
 * @Return
 */
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test01(){

    }
}

//自定义一个注解，一个类中不能有两个public的类， 否则报错，所以这个内部类不用加public
//自定义注解

    //下面是@Target的源码
//@Documented
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.ANNOTATION_TYPE)
//public @interface Target {
//    /**
//     * Returns an array of the kinds of elements an annotation type
//     * can be applied to.
//     * @return an array of the kinds of elements an annotation type
//     * can be applied to
//     */
//    ElementType[] value();   这里是参数集合，所以这里必须传入参数，可以点开ElementType这个进入看它的源码
//}
//    枚举类型里面好多定义
//public enum ElementType {
//    /** Class, interface (including annotation type), or enum declaration */
//    TYPE,
//
//    /** Field declaration (includes enum constants) */
//    FIELD,
//
//    /** Method declaration */
//    METHOD,
//
//    /** Formal parameter declaration */
//    PARAMETER,
//
//    /** Constructor declaration */
//    CONSTRUCTOR,
//
//    /** Local variable declaration */
//    LOCAL_VARIABLE,
//
//    /** Annotation type declaration */
//    ANNOTATION_TYPE,
//
//    /** Package declaration */
//    PACKAGE,
//
//    /**
//     * Type parameter declaration
//     *
//     * @since 1.8
//     */
//    TYPE_PARAMETER,
//
//    /**
//     * Use of a type
//     *
//     * @since 1.8
//     */
//    TYPE_USE
//}


//@Target(value= ElementType.METHOD)//定义的作用域为method，只能在方法上用
@Target(value={ElementType.TYPE,ElementType.METHOD})
//retention表示这个注解在什么时候还有效，一般写的是runtime，RetentionPolicy也是枚举类型的，这里就不看源码了。
@Retention(RetentionPolicy.RUNTIME)
//表示该注解是否生成在Javadoc中
@Documented
//表示子类是否可以能继承父类的注解
@Inherited
@interface MyAnnotation{

}
