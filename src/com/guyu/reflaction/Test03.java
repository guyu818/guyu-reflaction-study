package com.guyu.reflaction;
/**
 * @Des 测试Class类的创建方式有哪些
 * @Author guyu
 * @Date 2020/3/28 9:53
 * @Param 
 * @Return 
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person=new Student();
        System.out.println("这个人的名字是"+person.name);

        //方式1 ；通过对象获取Class类,不需要抛出异常，因为这里已经知道肯定有这个类了
        Class  c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二： forname获得，需要知道包名,不确定有没有这个类，所以要抛出异常
        Class c2 = Class.forName("com.guyu.reflaction.Student");
        System.out.println(c2.hashCode());

        //方式三： 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：比较局限了，一般只有内置类型的包装类才可以用，他们都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}
class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
         public Student(){
             this.name="学生";
         }
}
class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}