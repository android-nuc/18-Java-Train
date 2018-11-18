package week01.dataandvar;

import week01.classandobject.Person;

/**
 * 演示不同包下子类对父类中属性和方法的访问情况
 */
public class Teacher extends Person {

    /**
     * 构造方法没有返回值
     * 方法名与类名一致
     *
     * @param name1
     * @param age1
     */
    Teacher(String name1, int age1) {
        //这里super是调用父类的构造方法
        //如果父类中的构造方法不设置为protected的话，这里就会报错
        super(name1, age1);
        //只能访问父类中使用protected，public修饰的属性和方法
        protectedName = name1;
        publicFun();
    }
}
