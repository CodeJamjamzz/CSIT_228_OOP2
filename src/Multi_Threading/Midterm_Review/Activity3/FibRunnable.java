package Multi_Threading.Midterm_Review.Activity3;

public class FibRunnable implements Runnable{
    int n;

    public FibRunnable(int n){
        this.n = n;
    }

    @Override
    public void run(){
        if(n == 0){
            Main.fibResults.add(0);
            return;
        } else if (n == 1){
            Main.fibResults.add(1);
            return;
        }

        try {
            Main.fibRunnables.get(n-1).join();
            Main.fibRunnables.get(n-2).join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        Main.fibResults.add(n,Main.fibResults.get(n-1) + Main.fibResults.get(n-2));
    }
}
