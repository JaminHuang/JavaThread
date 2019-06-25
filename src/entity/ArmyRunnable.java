package entity;

public class ArmyRunnable implements Runnable {

    //volatile保证可以更正确的读取其他线程写入的值
    //可见性 ref JMM
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            //发动5次攻击
            for (int i = 1; i<=5;i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]");
            }
            //让出了处理器时间
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}
