package hw03.task02;

public class Main {
    public static void main(String[] args) {
        LockCounter lockCounter = new LockCounter();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    lockCounter.increaseCounter();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
