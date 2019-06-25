package model;

public class Main {
    public static void main(String[] args) {
        new MyThred();
    }
}

class MyThred implements Runnable {
    Customer c = new Customer();
    Waiter w = new Waiter();

    public MyThred() {
        new Thread(this).start();
        w.say(c);
    }

    @Override
    public void run() {
        c.say(w);
    }
}
