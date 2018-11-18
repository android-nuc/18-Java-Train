package week01.classandobject;

/**
 * 演示Java类的运行顺序
 */
public class ClassOrder {

    private String name = "baoqianyue";

    private int age;

    public ClassOrder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ClassOrder clazz = new ClassOrder("bao", 20);
        System.out.println(clazz.name + " " + clazz.age);
    }
}

//1.运行到17行，这里是程序入口
//2.然后到18行，这里要创建一个对象，就去调用类的构造函数
//3.到12行
//4.可能你会认为这时会运行13，14行，这是错误的，初始化一个类首先要初始化它的属性，所以这时运行8和10行
//并为他们赋上初始值,如果没有指定值,就赋值为null或者0
//5.然后返回到构造函数中运行13，14行
//6.然后返回到主函数中运行19行