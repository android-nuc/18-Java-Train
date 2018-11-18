package week01.dataandvar;

/**
 * 演示Java数据类型
 */
public class Datatype {


    public static void main(String[] args) {
        //字符型
        char name1 = '鲍';
        char name2 = '骞';
        char name3 = '月';
        System.out.println("姓名是：" + name1 + name2 + name3);

        //整形
        short a = 7; //十进制
        int b = 07; //八进制
        long c = 0x7L; //十六进制

        System.out.println("转成十进制输出：" + " a = " + a + " b = " + b + " c = " + c);

        //浮点型
        float d = 21.34f;
        double n = 10; //编译器会给它加上小数点，并且小数位置零
        System.out.println("计算乘积: " + d + "*" + n + "=" + d * n);

        //boolean类型
        boolean e = 10 > 100;
        //C++中是1和0
        System.out.println("10 > 100: " + e);
    }
}
