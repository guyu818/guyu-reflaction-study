package com.guyu.reflaction;
/**
 * @Des 测试类什么时候被初始化
 * @Author guyu
 * @Date 2020/3/28 11:37
 * @Param
 * @Return
 */
public class Test06 {
    static {
        System.out.println("MAIN类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {

        //类的主动引用，一定会发生初始化
        //1。主动引用
        //Son son=new Son();

        //2.通过反射也可以主动引用，但是极大的消耗资源
//        Class.forName("com.guyu.reflaction.Son");

        //被动引用不会初始化
        //这里子类调用父类的静态参数，所以子类没有被加载，只有父类被加载了
//        System.out.println(Son.b);

        //数组也不会初始化加载东西,父类和子类都没有初始化加载
        Son[] array=new Son[5];
    }
}
class Father{
    static int b=2;
    static {
        System.out.println("父类被加载");
    }
}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        m=300;
    }

    static int m=100;
    static final int M=1;

}

