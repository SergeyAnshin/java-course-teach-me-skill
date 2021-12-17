package old;

public class Manager {

    public void updateAndPrintInfo(int[] array, int value) {
        synchronized (array) {
            for (int i = 0; i < array.length; i++) {
                array[i] = value;
            }

            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
