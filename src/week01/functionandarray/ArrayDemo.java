package week01.functionandarray;


/**
 * 演示数组
 */
public class ArrayDemo {

    public static void main(String args[]) {

        /**
         * 数组定义方式
         */

        //1.指定数组名和数组长度，如果后续不进行每个元素的赋值的话，系统会默认给元素都赋初值为0
        int[] arr = new int[2];
        //定义好之后，可以给每个元素进行赋值
        arr[1] = 0;
        //中括号放在数组名前和后等价
        int arr1[] = new int[2];
        //2.直接给数组中每个元素赋值，可以不指定数组长度，系统会自行计算
         int[] arr2 = new int[]{3, 2, 3};
        //可以不写new int []，等价
        int[] arr3 = {3, 2, 3};

        //默认赋值为0
//        System.out.println(arr1[0]);
        //访问下标越界，编译时检查不出来，是运行时异常：ArrayIndexOutOfBoundsException: 3
//        System.out.println(arr2[3]);
        //空指针异常：NullPointerException
        arr3 = null;
//        System.out.println(arr3[0]);

        /**
         * 遍历数组
         */
        int[] array = new int[]{2, 32, 1, 4, 43, 4};
        //这里使用数组的属性length,自动计算数组长度
        //数组length的实现,是编译器在编译的时候识别出数组的length字段的访问
        //然后动态生成对应的字节码文件
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "]" + "=" + array[i]);
        }

        //使用逗号将数组每个元素隔开
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1)
                System.out.print(array[i] + ",");
            else
                System.out.print(array[i]);
        }
        System.out.println();

        //使用for-Each遍历数组,简单粗暴
        //这里element用来保存当前遍历到的元素值,每次循环,element的值都会发生变化,直到将数组全部遍历完
        //array代表要遍历的容器
        for (int element :
                array) {
            System.out.print(element + " ");
        }
        System.out.println();


        //打印数组的引用
        System.out.println(array); //[I@1540e19d
        //中括号代表这是一个数组,I代表int类型,后面是该数组在内存中的起始地址,由hash算法计算而来,使用16进制表示

        /**
         * 二维数组
         */
        //这三种定义方式等价
        int arr4[][] = new int[3][4];
        int[][] arr5 = new int[3][4];
        int[] arr6[] = new int[3][4];

        //直接赋值
        int[][] arr7 = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };

        //遍历二维数组
        for (int i = 0; i < arr7.length; i++) {
            System.out.print("{");
            for (int j = 0; j < arr7[i].length; j++) {
                System.out.print(arr7[i][j] + " ");
            }
            System.out.println("}");
        }

    }
}
