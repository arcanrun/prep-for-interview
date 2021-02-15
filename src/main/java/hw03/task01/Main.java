package hw03.task01;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WordContainer wordContainer = new WordContainer();
        new Thread(() -> {
            while (true) {
                wordContainer.printPing();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);

        new Thread(()->{
            while (true){
                wordContainer.printPong();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
