package week01.dataandvar;

/**
 * 演示流程控制
 */
public class ProcessControl {

    public static void main(String[] args) {

        //九九乘法表
        /**
         * 1 x 1 = 1
         * 1 x 2 = 2 2 x 2 = 4
         * 1 x 3 = 3 2 x 3 = 6 3 x 3 = 9
         */
        /*for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }*/

        /*
              *
             * *
            * * *
           * * * *
          * * * * *
        */

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        /**
         * switch结构判断从键盘输入的年月是不是闰年
         */
    }
}
