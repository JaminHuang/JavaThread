package model;

public class Customer {
    public synchronized void say(Waiter w) {
        System.out.println("Customer: Do --> Pay");
        w.doService();
    }

    public synchronized void doService() {
        System.out.println("Customer: OK");
    }
}
