package Multi_Threading.Activity4;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(5000);
        Thread thread1 = new Thread(new Sender(data));
        Thread thread2 = new Thread(new Reciever(data));

        thread2.start();
        thread1.start();
    }
}
