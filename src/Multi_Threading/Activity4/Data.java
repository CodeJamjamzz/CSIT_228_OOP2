package Multi_Threading.Activity4;

public class Data {
    int amount;
    String message;
    boolean transfered = false;

    public Data(int amount){
        this.amount = amount;
        this.message = "";
    }

    public synchronized void recieve(){
        try {
            this.wait();
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Thread has been Interrupted");
        }
        transfered = true;
        System.out.println("Message: " + message + ", " + "Amount: " + amount);
    }

    public synchronized void send() {
        if(transfered) {
            return;
        }
        this.message = "Amound sent";
        try {Thread.sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Thread has been Interrupted");
        }
        this.notify();
    }
}

class Sender implements Runnable {
    Data data;

    public Sender(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.send();
    }
}

class Reciever implements Runnable {
    Data data;

    public Reciever(Data data){
        this.data = data;
    }

    @Override
    public void run(){
        data.recieve();
    }
}