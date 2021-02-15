package hw03.task02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter {
    private int counter;
    private final Lock lock;

    public LockCounter() {
        lock = new ReentrantLock(true);
    }

    public int increaseCounter() {

        lock.lock();
        try {
            counter++;
            System.out.println(counter);
        } finally {
            lock.unlock();
        }
        return counter;
    }
}
