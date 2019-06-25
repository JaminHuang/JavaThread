package entity;

public class KeyPersonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始战斗");
        for (int i = 1;i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "进行了特殊攻击……");
        }

        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}
