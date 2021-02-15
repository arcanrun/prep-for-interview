package hw03.task01;

public class WordContainer {
    private String word;

    public WordContainer() {
        word = "ping";
    }

    public synchronized void printPing() {
        if(!word.equals("ping")){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(word);
        word = "pong";
        notify();

    }

    public synchronized void printPong(){
        if(!word.equals("pong")){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(word);
        word = "ping";
        notify();

    }

}

