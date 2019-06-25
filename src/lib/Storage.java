package lib;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源类
 */
public class Storage {
    private String type;
    private String date;

    private boolean isEmpty = true;

    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 生产者向共享资源存储数据
     * @param type
     * @param date
     */
    public void push(String type, String date) {
        lock.lock(); //获取对象锁
        try {
            while (!isEmpty) {
                // 当前共享资源状态不为空，等待消费者消费
                condition.await();
            }
            // 生产开始
            this.type = type;
            Thread.sleep(10);
            this.date = date;
            // 生产结束
            isEmpty = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock(); //释放对象锁
        }
    }

    /**
     * 消费者从共享资源中取出数据，并打印
     */
    public void popup() {
        lock.lock();
        try {
            while (isEmpty) {
                //当资源为空，释放同步锁，进入等待
                condition.await();
            }
            Thread.sleep(10);
            //消费开始
            System.out.println(this.type + "-->" + this.date);
            //消费结束
            isEmpty = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
