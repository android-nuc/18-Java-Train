package week03;


/**
 * 多线程-懒汉式单例模式
 */

//饿汉式
class Single {
    private static final Single instance = new Single();

    private Single() {

    }

    public static Single getInstance() {
        return instance;
    }
}

//懒汉式单例模式

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if (null == instance) {
            //延迟加载
            //但是会出现线程安全问题，有多条语句会操作instance
            //当多个线程并发执行时，可能都会判断null==instance，会new出来多个对象
            //所以加锁
            instance = new Singleton();
        }
        return instance;
    }
}
//上面的懒汉式单例虽然解决了线程同步问题，但是却有些低效，为什么
//因为如果多个线程多次调用getInstance()，每次都会去判断一次锁
//可以有如下改进方式

class SingletonPro {
    private static SingletonPro instance = null;

    private SingletonPro() {
    }

    public static SingletonPro getInstance() {
        //使用双重判断方式
        //如果有两个线程来访问
        //第一个线程经过第一个判断，然后获得锁，创建对象
        //这时第二个线程也经过第一个判断，但是获取不到锁，等待
        //这时第一个线程执行结束，释放锁，第二个线程进入同步块，但是不满足第二个判断，退出
        //这时如果有第三个第四个线程来访问，都不满足第一个判断
        if (null == instance) {
            synchronized (SingletonPro.class) {
                if (null == instance) {
                    instance = new SingletonPro();
                }
            }
        }
        return instance;
    }

}
