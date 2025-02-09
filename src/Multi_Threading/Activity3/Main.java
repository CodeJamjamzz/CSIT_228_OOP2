package Multi_Threading.Activity3;

public class Main {
    public static void main(String[] args) {
        Message message = new Message("Default");
        Waiter waiter = new Waiter(message);
        Notifier notifier = new Notifier(message);

        Thread thread1 = new Thread(waiter);
        Thread thread2 = new Thread(notifier);

        thread1.start();
        thread2.start();

    }
}
