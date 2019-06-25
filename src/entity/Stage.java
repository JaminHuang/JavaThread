package entity;

public class Stage extends Thread {

    @Override
    public void run() {
        ArmyRunnable armyTaskDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskRevolt = new ArmyRunnable();

        Thread armyDynasty = new Thread(armyTaskDynasty, "隋军");
        Thread armyRevolt = new Thread(armyTaskRevolt, "农民起义军");

        //启动线程
        armyDynasty.start();
        armyRevolt.start();

        //舞台线程休眠
        try {
            Thread.sleep(50);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("正当双方进行激斗的时候，半路杀出了程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");

        System.out.println("程咬金的理想就是结束战争");

        //停止线程,不能使用stop方法来停止线程
        armyTaskDynasty.keepRunning = false;
        armyTaskRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        mrCheng.start();

        try {
            mrCheng.join();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.run();
    }
}
