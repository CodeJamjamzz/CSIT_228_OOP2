package Multi_Threading.Activity3;

public class Message {
    String message;

    public Message(String message){
        this.message = message;
    }

    public void setMessage(String message){this.message = message;}
    public String getMessage(){return message;}
}

class Waiter implements Runnable {
    Message message;

    public Waiter(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        synchronized (message){
            try{
                message.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Thread was interrupted");
            }

            System.out.println("Message: " + message.getMessage());
        }
    }
}

class Notifier implements Runnable {
    Message message;

    public Notifier(Message message){
        this.message = message;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(3000);
            synchronized (message){
                message.setMessage("Everything is good");
                message.notify();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Thread was interrupted");
        }
    }
}