package synchronous;
/**
 * 多线程共享数据
 * 线程同步：多个线程在同一时间段只能有一个线程执行指定代码，其他线程要等待此线程完成之后才可以继续执行
 * 多线程共享数据的安全问题，使用同步解决
 * 2.同步方法：public synchronized void method() { 要同步的操作 }
 */
public class SyncMethod {

    public static void main(String[] args) {
        MyThread s0 = new MyThread();
        Thread t1 = new Thread(s0, "one");
        Thread t2 = new Thread(s0, "two");
        t1.start();
        t2.start();
    }
}
