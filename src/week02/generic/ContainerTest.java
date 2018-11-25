package week02.generic;

import java.util.ArrayList;

public class ContainerTest extends Container<String, String> {

    public ContainerTest(String s, String s2) {
        super(s, s2);
    }

    public static void main(String[] args) {
        Class class1 = new ArrayList<Integer>().getClass();
        Class class2 = new ArrayList<String>().getClass();

        System.out.println(class1 == class2);
        System.out.println(class1.equals(class2));
        //输出为true
    }


}