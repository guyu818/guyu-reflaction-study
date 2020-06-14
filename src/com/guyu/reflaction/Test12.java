package com.guyu.reflaction;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @Des 反射操作注解
 * @Author guyu
 * @Date 2020/3/28 16:01
 * @Param
 * @Return
 */
//框架里面好多都是这样的，通过在类里面定义大量的注解，来通过反射框架读取注解，生成相应的信息。通过注解生成一些数据库的语言实现增删改查都是可以的
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.guyu.reflaction.Student2");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获得注解的值
        TableGu tableGu = (TableGu)c1.getAnnotation(TableGu.class);
        String value=tableGu.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldGu annotation = f.getAnnotation(FieldGu.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());

    }
}

@TableGu("db_student")
class Student2{

    @FieldGu(columnName = "db_id",type="int",length = 10)
    private int id;
    @FieldGu(columnName = "db_age",type="int",length = 10)
    private int age;
    @FieldGu(columnName = "db_name",type="varchar",length = 3)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableGu{
    String value();
}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldGu{
    String columnName();
    String type();
    int length();
}

