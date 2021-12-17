package secondpart;

public class CounterIncThread implements Runnable {
    private Counter counter;

    public CounterIncThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getNumber() < 1000000000) {
            counter.inc();
        }
    }
}
