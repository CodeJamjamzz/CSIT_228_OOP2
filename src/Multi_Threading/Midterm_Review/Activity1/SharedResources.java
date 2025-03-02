package Multi_Threading.Midterm_Review.Activity1;

import java.util.Random;

public class SharedResources {
    private int value;
    boolean available;

    public SharedResources(int value){
        available = true;
        this.value = value;
    }

    synchronized public void produce() throws InterruptedException {
        for(int i = 0; i < 5; i++){
            this.wait();
            Random random = new Random();
            value = random.nextInt(1,51);
            System.out.println("Produced: " + value);
            available = true;
            this.notify();
        }
    }

    synchronized public void consume() throws InterruptedException {
        for(int i = 0; i < 5; i++) {
            if (!available) {
                this.wait();
            }

            System.out.println("Consumes: " + value);
            available = false;
            this.notify();
        }
    }
}

class Producer implements Runnable {
    SharedResources shared;

    public Producer(SharedResources shared){
        this.shared = shared;
    }

    @Override
    synchronized public void run(){
        try {
            shared.produce();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    SharedResources shared;

    public Consumer(SharedResources shared){
        this.shared = shared;
    }

    @Override
    synchronized public void run(){
        try {
            shared.consume();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
