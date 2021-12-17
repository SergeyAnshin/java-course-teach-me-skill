package old;

public class MyThirdThread implements Runnable {
    private Manager manager;
    private A a;
    private int value;

    public MyThirdThread(Manager manager, A a, int value) {
        this.manager = manager;
        this.a = a;
        this.value = value;
    }

    @Override
    public void run() {
        manager.updateAndPrintInfo(a.getArray(), value);
    }
}
