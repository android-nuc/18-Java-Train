package week01.dataandvar;

import week01.classandobject.Person;

/**
 * 演示数据类型转换
 */
public class DataConvert {

    public String importStr;

    public static void main(String[] args) {
        //自动类型转换
        int a = 10;
        double b = 23.1d;
        double c = a * b;
        System.out.println(c);

        //强制类型转换
        int x;
        double y;
        x = (int) 32.3 + (int) +10.2; //损失精度
        y = (double) x + (double) 10 + 1; //提高精度

        System.out.println("x= " + x);
        System.out.println("y= " + y);
    }

    /**
     * 演示不同包下访问其他包protected和public修饰的内容
     */
    public void importFun() {
        String name = Person.publicStaName;
        Person.publicFun();
    }
}
