package old;

public class MySecondThread implements Runnable {
//    private Thread thread;
//
//    public old.MySecondThread() {
//        this.thread = new Thread();
//    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
    }
}
