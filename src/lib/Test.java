package lib;

public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage();

        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);

        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);

        Thread t1 = new Thread(p1, "P1");
        Thread t2 = new Thread(p2, "P2");
        Thread t3 = new Thread(c1, "C1");
        Thread t4 = new Thread(c2, "C2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
