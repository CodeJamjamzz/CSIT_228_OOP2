package Multi_Threading.Midterm_Review.Activity3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Thread> fibRunnables;
    static ArrayList<Integer> fibResults;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter length of fibo sequence: ");
        int n = scan.nextInt();

        fibRunnables = new ArrayList<>(n);
        fibResults = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            fibRunnables.add(i, new Thread(new FibRunnable(i)));
            fibRunnables.get(i).start();
        }

        try {
            fibRunnables.get(n-1).join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Fibonacci Sequence: ");
        for(int i = 0; i < n; i++){
            System.out.print(fibResults.get(i) + " ");
        }
    }
}
