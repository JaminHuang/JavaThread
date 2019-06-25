package synchronous;

public class MyThread implements Runnable {

    Object obj = new Object(); //同步的标记对象

    @Override
    public void run() {
//        synchronized (obj) {
//            System.out.println(Thread.currentThread().getName() + " is doing...");
//            try {
//                Thread.sleep(1000);
//            }
//            catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " finished.");
//        }
        doMethod();
    }

    /**
     * 同步方法，同步的是对象(this)
     */
    public synchronized void doMethod() {
        System.out.println(Thread.currentThread().getName() + " is doing...");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}
