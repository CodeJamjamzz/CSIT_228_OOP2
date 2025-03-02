package Multi_Threading.Midterm_Review.Activity1;

public class Main {
    public static void main(String[] args) {
        SharedResources shared = new SharedResources(5);

        Thread thread1 = new Thread(new Producer(shared));
        Thread thread2 = new Thread(new Consumer(shared));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Producer and Consumer have ended");
    }
}
