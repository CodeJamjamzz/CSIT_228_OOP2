package Multi_Threading.Midterm_Review.Activity2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        Thread thread1 = new Thread(new DepositeThread(account));
        Thread thread2 = new Thread(new WithdrawThread(account));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Withdraw and Deposite finished...");
    }
}
