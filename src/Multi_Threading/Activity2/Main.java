package Multi_Threading.Activity2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Operations operations = new Operations(array);
        Thread thread1 = new Thread(operations);

        Analyze analyze = new Analyze(operations);
        Thread thread2 = new Thread(analyze);

        thread1.start();


        synchronized (operations) {
            operations.wait();
        }

        thread2.start();
        thread2.join();

        System.out.println(analyze.getAns());
    }
}