package Multi_Threading.Activity1;

import java.util.ArrayList;

public class MyArrayList <E> implements Runnable {
    private ArrayList<E> array;
    private int size;
    private int start, end;

    private int sum;

    public MyArrayList(){
        size = 0;
        sum = 0;
        this.start = 0;
        this.end = size;
        array = new ArrayList<E>();
    }

    public void add(E value){
        size++;
        array.add(value);
    }

    public int getSum(){
        return sum;
    }

    public int getSize(){
        return size;
    }

    void changeRange(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i < end; i++){
            if(array.get(i).equals(1) ){
                sum++;
            }
        }
    }
}
