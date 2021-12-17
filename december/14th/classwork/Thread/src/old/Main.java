package old;

public class Main {
    public static void main(String[] args) {
//        old.MyFirstThread myFirstThread = new old.MyFirstThread();
//        myFirstThread.start();

//        old.MySecondThread mySecondThread = new old.MySecondThread();
//        Thread thread = new Thread(mySecondThread);
//        thread.start();
//        System.out.println("End code");

        A a = new A();
        Manager manager = new Manager();
        MyThirdThread thirdThread = new MyThirdThread(manager, a, 1);
        MyThirdThread thirdThread1 = new MyThirdThread(manager, a, 2);
        Thread thread = new Thread(thirdThread);
        Thread thread1 = new Thread(thirdThread1);
        thread.start();
        thread1.start();

    }
}
