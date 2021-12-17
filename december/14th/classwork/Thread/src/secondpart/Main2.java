package secondpart;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        Counter counter = new Counter();

        CounterIncThread incThread = new CounterIncThread(counter);
        Thread thread = new Thread(incThread);
        thread.start();
        Thread thread1 = new Thread(incThread);
        thread1.start();
        Thread thread3 = new Thread(incThread);
        thread3.start();

        long end = System.nanoTime();
        System.out.println(end - start);


    }

}
