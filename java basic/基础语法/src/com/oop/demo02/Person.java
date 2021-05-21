package com.oop.demo02;

public class Person {
    //一个类即使什么也不写，也存在一个方法。与类名字相同，叫构造方法
    //显示的定义构造器

    String name;
    int age;
    //构造方法作用
    //1.实例化初始值
    //使用new关键字，必须要有构造器,本质是在调用构造器
    //默认的无参构造器是隐藏的
    //用来初始化值

    public Person() {
    }

    //有参构造：一旦定义了有参构造,无参构造必须显示定义
    public Person(String name) {
        this.name = name;
    }
    //两个参数的有参构造
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
/*构造器
    1.和类名相同
    2.没有返回值
  作用：
    1.new 本质是在调用构造方法
    2.初始化对象的值
  注意点：
    1.定义有参构造之后，如果想用无参构造，显示的定义一个无参构造
 */

