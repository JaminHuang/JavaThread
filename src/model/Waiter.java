package model;

public class Waiter {

    public synchronized void say(Customer c) {
        System.out.println("Waiter: Pay --> Do");
        c.doService();
    }

    public synchronized void doService() {
        System.out.println("Waiter: OK");
    }
}
