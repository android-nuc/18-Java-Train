package week01.classandobject;

/**
 * 演示protected权限修饰符
 */
public class Student {

    Student(String name) {
        //同一个包下的其他类可以访问到类中protected修饰的属性
        Coder.protectedStaName = name;
        Person.protectedFun();
    }
}
