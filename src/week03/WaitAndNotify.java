package week03;

/**
 * 线程等待唤醒机制
 * wait
 * notify
 * notifyAll
 * 上面三个方法都必须使用在同步中，因为这些方法必须要对持有锁的线程进行操作
 * 只有在同步块或者同步函数中，才有锁
 * <p>
 * 使用wait会将当前持有锁的线程等待，并存放在线程池中
 * 使用notify也会从线程池中将持有该锁的线程唤醒
 * <p>
 * 为什么这些方法被定义在Object类中？
 * 因为这些方法在操作同步中的线程时，都必须标识它们所操作线程持有的锁
 * 只有同一个锁上的被等待线程，能被同一锁notify唤醒，不能对不同锁中的等待线程进行唤醒
 * 等待和唤醒必须是同一个锁
 * 锁是任意对象，所以定义在Object类中
 */


/**
 * 这里生产者消费者模型，因为没有设置缓冲
 * 所以理论上应该是input生产一个res
 * 然后output消费一个res
 * 两个线程应该交替进行
 * 上一个例子中，明显看到每个线程都可以执行多次
 * 所以这里使用等待唤醒机制
 */
class Res {
    String name;
    String type;
    //首先给资源加上一个标记位
    //当flag为false时，表示此时还没有资源被生产出来
    //当flag为true时，表示当前已经有资源被生产，此时需要input来将资源取走
    boolean flag = false;
}

class In implements Runnable {

    private Res res;

    public In(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (res) {
                //如果资源标记位为true，表示已有资源，此时将input线程wait
                //在wait时，需要使用
                if (res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 0) {
                    res.name = "bao";
                    res.type = "cool";
                } else {
                    res.name = "wang";
                    res.type = "low";
                }
                i = (i + 1) % 2;
                //将标记位修改为true，表示当前已有资源被创建
                res.flag = true;
                //input生产完成后，需要将output线程唤醒
                res.notify();
            }
        }
    }
}

class Out implements Runnable {

    private Res res;

    public Out(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                //如果资源标记位为false，表示当前已没有资源，所以将output线程wait
                //但是在wait之前需要将input线程唤醒
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "...." + res.type);
                //在上面将资源打印之后，表示资源已经被消费
                //所以这里先将标记位置为false，而且ouput线程此时应该wait
                //在wait之前必须将input线程唤醒
                res.flag = false;
                res.notify();
            }
        }
    }
}

public class WaitAndNotify {

    public static void main(String[] args) {
        //两个线程同时操作一个资源对象
        Res res = new Res();
        In in = new In(res);
        Out out = new Out(res);
        Thread inT = new Thread(in);
        Thread outT = new Thread(out);
        inT.start();
        outT.start();
    }
}
