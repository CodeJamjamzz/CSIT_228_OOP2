package Multi_Threading.Activity1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyArrayList<Integer> array = new MyArrayList<Integer>();
        System.out.println("Enter number: ");
        int size = scan.nextInt();

        int num;
        for(int i = 0; i < size; i++){
            array.add(scan.nextInt());
        }
        array.changeRange(0, array.getSize());
        Thread thread = new Thread(array);
        thread.start();

        try{
            thread.join();
        } catch (InterruptedException e){
            System.out.println("The thread was Intruppted");
        }

        System.out.println("Sum: " + array.getSum());
    }
}
