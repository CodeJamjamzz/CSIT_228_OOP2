package Generic_Classes;

public class Main {
    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>("Jamiel", 19);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        MyArray<Integer> array = new MyArray<>();
        array.add(1);
        array.add(2);
        array.add(3);

        array.display();
    }
}
