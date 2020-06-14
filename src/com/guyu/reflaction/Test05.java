package com.guyu.reflaction;
/**
 * @Des 了解类加载过程
 * @Author guyu
 * @Date 2020/3/28 10:24
 * @Param
 * @Return
 */
public class Test05 {
    public static void main(String[] args) {
        A a=new A();
        System.out.println(A.m);//结果m=100
        /*
        类加载过程
        1.加载到内存，会产生一个类对应的Class对象
        2.链接，链接结束后 m=0，
        3.初始化
        <clinit>(){
                    System.out.println("A类静态代码块被加载");
                    m=300
                    m=100
        }

        m=100
         */
    }
}
class A{
    static {
        System.out.println("A类静态代码块被加载");
        m=300;
    }
    /*
    对m的操作可以堪称这两步
    1.m=300;
    2.m=100;
     */

    static int m=100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
