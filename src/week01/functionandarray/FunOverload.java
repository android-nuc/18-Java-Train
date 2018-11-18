package week01.functionandarray;

/**
 * 演示函数重载
 */
public class FunOverload {

    //返回两个整数的和
    public static int sum(int a, int b) {
        return a + b;
    }

    //返回三个整数的和
    public static int sum(int a, int b, char c) {
//        return a + b + c;
        //可以直接调用被重载的函数
        return sum(a, b) + c;
    }

    //返回值不同不能构成重载
//    public static double sum(int a , int b) {
//    }


    public static void main(String[] args) {

    }
}
