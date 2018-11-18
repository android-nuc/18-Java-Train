package week03;

/**
 * 死锁
 * 可以想象为两个人同时吃饭，但是每个人只有一根筷子
 * a向b索要筷子，b也向a索要筷子，两个人僵持不下，结果谁也不能吃饭
 * 但是如果出现a将筷子先给了b，b然后又将筷子给了a，程序就能正常运行了
 */

//买票程序模拟死锁
class Ticket implements Runnable {

    private int ticket = 100;
    Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {

    }
}


public class DeadLockDemo {
}
