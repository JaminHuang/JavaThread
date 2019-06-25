package lib;

/**
 * 生产者
 */
public class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2==0) {
                storage.push("apple", "20190625001");
            }
            else {
                storage.push("banana", "20190625002");
            }
        }
    }
}
