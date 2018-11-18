package week01.classandobject;

/**
 * 演示基本数据类型包装类
 */
public class DataWrapper {

    public static void main(String[] args) {
        //使用包装类输出int类型的取值范围
        System.out.println("int类型的取值范围为： " + Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);

        int a = 20;
        Integer aWrapper = new Integer(a);//手动装箱
        int b = aWrapper.intValue(); //手动拆箱
    }
}
