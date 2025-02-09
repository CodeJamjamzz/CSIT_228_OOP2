package Generic_Classes;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray <T> {
    private ArrayList<T> array;

    public MyArray(T array){
        array = (T) new ArrayList<>(Arrays.asList(array));
    }

    public MyArray(){
        array = new ArrayList<>();
    }

    public void add(T value){
        array.add(value);
    }

    public void display(){
        for(T i : array){
            System.out.print(i + " ");
        }
    }
}
