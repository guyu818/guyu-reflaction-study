package com.guyu.reflaction;
/**
 * @Des 类加载器的认识
 * @Author guyu
 * @Date 2020/3/28 12:24
 * @Param 
 * @Return 
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器------》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获得扩展类加载器的父类加载器----》根加载器（c/c++编写的，所以你查看不了)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.guyu.reflaction.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试Object类JDK内置类是谁加载的，因为是rt.jar包下的，是老祖宗类加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //拓展，双亲委派机制； 比如自己定义了一个java.lang.String--->>自己一级级向上推--》先看用户加载器有没有---》再去拓展类加载器--》》再去根加载器，
        // 如果发现已经存在相同的类名，那么就用系统给的，不能用自己定义的，否则会出现安全问题，这是出于安全考虑的。

        //如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\charsets.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\deploy.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\access-bridge-64.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\cldrdata.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\dnsns.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jaccess.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\jfxrt.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\localedata.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\nashorn.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunec.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunjce_provider.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunmscapi.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\sunpkcs11.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\ext\zipfs.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\javaws.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\jce.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfr.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\jfxswt.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\jsse.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\management-agent.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\plugin.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\resources.jar;
        C:\Program Files\Java\jdk1.8.0_131\jre\lib\rt.jar;
        F:\com.guyu.Reflaction\out\production\com.guyu.Reflaction;
        F:\IDEA2019\IntelliJ IDEA 2019.1\lib\idea_rt.jar

         */


    }
}
