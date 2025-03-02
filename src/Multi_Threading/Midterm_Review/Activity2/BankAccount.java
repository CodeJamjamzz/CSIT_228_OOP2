package Multi_Threading.Midterm_Review.Activity2;

public class BankAccount {
    public Double balance;
    public Object lock = new Object();

    public BankAccount(){
        this.balance = (Double) 500.00;
    }

    public void deposit(double amount){
        synchronized (lock){
            balance += amount;
            System.out.println("Deposite Balance: " + balance);
            lock.notify();
        }
    }

    public void withdraw(double amount){
        synchronized (lock) {
                while(balance < amount){
                    try {
                            lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (amount >= balance || amount < 0) {
                        System.out.println("Insufficient Balance");
                        return;
                    }

                }

            balance -= amount;
            System.out.println("Withdraw Balance: " + balance);
            lock.notify();
        }
    }
}

class DepositeThread implements Runnable {
    BankAccount account;
    public DepositeThread(BankAccount account){
        this.account = account;
    }

    @Override
    public void run(){
        for(int i = 100; i <= 500; i+= 100) {
                account.deposit(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class WithdrawThread implements Runnable {
    BankAccount account;
    public WithdrawThread(BankAccount account){
        this.account = account;
    }

    @Override
    public void run(){
        for(int i = 100; i <= 500; i+= 100) {
                account.withdraw(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
