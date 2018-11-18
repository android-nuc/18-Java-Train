package week03;


/**
 * 进程间通信
 * 这个与之前举得例子的主要区别
 * 之前每个线程运行的代码都是一致的
 * 线程间通信中每个线程的操作不一致
 * 一个线程负责存数据
 * 一个线程负责取数据
 * 模拟生产者和消费者
 */

class Resource {
    public String name;
    public String type;
}

//相当于生产者
class Input implements Runnable {

    private Resource res;
    private boolean flag = true;

    public Input(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        //轮换给资源赋值
        //这里会出现线程安全问题
        //假如input线程已经正常执行过一次
        //此时res.name="bao";res.type="cool"
        //第二次执行时，应该执行else内的代码
        //当给res.name赋值为“wang”后，这时Output线程获取到了cpu的控制权
        //所以输出了wang....cool
        //所以这两条赋值语句可以看成是共享数据
        //会被多个线程同时访问

        //怎么解决这个问题
        //就是给操作共享数据的语句加锁
        //这里就是给赋值语句加上同步块
        //但是要注意我们需要给所有对临界资源上锁，而且必须是同一个锁
        //这样才满足同步执行的条件
        //其实在output中的sout语句也是在操作临界资源res
        while (true) {
            synchronized (res) {
                if (flag) {
                    res.name = "bao";
                    res.type = "cool";
                    flag = false;
                } else {
                    res.name = "wang";
                    res.type = "low";
                    flag = true;
                }
            }
        }
    }
}

//相当于消费者
class Output implements Runnable {

    private Resource res;

    public Output(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            //这里的输出语句也是对临界资源的操作
            //所以加上与input中同样的锁
            //这个锁对象就是res
            synchronized (res) {
                System.out.println(res.name + "...." + res.type);
            }
        }
    }
}

public class ThreadMessage {

    public static void main(String[] args) {
        //两个线程操作同一个Resource对象
        Resource resource = new Resource();
        Input input = new Input(resource);
        Output output = new Output(resource);
        Thread inputT = new Thread(input);
        Thread outputT = new Thread(output);
        inputT.start();
        outputT.start();
    }
}
