package com.guyu.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * @Des 认识什么是注解
 * @Author guyu
 * @Date 2020/3/27 21:42
 * @Param 
 * @Return 
 */

//@SuppressWarnings("all")也可以放在这里抑制整个类的警告
public class Test01 extends Object{

    //这个@override就是一个注解，代表重写
    @Override
    public String toString() {
        return super.toString();
    }

    //这个注解代表不推荐使用，可能有更好的方法来代替
    @Deprecated
    public static void test01(){
        System.out.println("Deprecated");
    }

    //这里将一些警告的信息给压制下去看不出来，因为这里创建了数组，并且没有用，程序会警告提示这个数组没有使用
    @SuppressWarnings("all")
    //下面是源码
//    @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})// 这个是作用范围，类，字段，方法，参数，构造器，局部变量等
//    @Retention(RetentionPolicy.SOURCE)
//    public @interface SuppressWarnings {
//        /**
//         * The set of warnings that are to be suppressed by the compiler in the
//         * annotated element.  Duplicate names are permitted.  The second and
//         * successive occurrences of a name are ignored.  The presence of
//         * unrecognized warning names is <i>not</i> an error: Compilers must
//         * ignore any warning names they do not recognize.  They are, however,
//         * free to emit a warning if an annotation contains an unrecognized
//         * warning name.
//         *
//         * <p> The string {@code "unchecked"} is used to suppress
//         * unchecked warnings. Compiler vendors should document the
//         * additional warning names they support in conjunction with this
//         * annotation type. They are encouraged to cooperate to ensure
//         * that the same names work across multiple compilers.
//         * @return the set of warnings to be suppressed
//         */
//        String[] value(); ********************这里注意，这里不是方法，这里是代表参数，参数的类型是字符串数组，所以这个注解必须要传入参数，这里要求的。
//    }

    public void test02(){
        List<String> list=new ArrayList<>();
    }

    public static void main(String[] args) {
        //主函数是静态的方法，当我们测试的时候如果不将方法声明成静态的，它会报错。
        test01();

    }
}
