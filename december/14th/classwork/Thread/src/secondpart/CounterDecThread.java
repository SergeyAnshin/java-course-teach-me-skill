package secondpart;

public class CounterDecThread implements Runnable {
    private Counter counter;

    public CounterDecThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            counter.dec();
        }
    }
}
