package Multi_Threading.Activity2;

import java.util.ArrayList;

public class Operations implements Runnable {
    ArrayList<Integer> list;
    public int sum;

    public Operations(ArrayList<Integer> list) {
        this.list = list;
        this.sum = 0;
    }

    @Override
    public void run() {
        synchronized (this) { // Synchronize on the Operations instance
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            // Notify Analyze thread that it can proceed after the summation is complete
            notify();
        }
    }
}

class Analyze implements Runnable {
    Operations operations;
    int ans;

    public Analyze(Operations operations) {
        this.operations = operations;
        ans = 0;
    }

    @Override
    public void run() {
        ans = operations.sum / operations.list.size();
    }

    public int getAns() {
        return ans;
    }
}
