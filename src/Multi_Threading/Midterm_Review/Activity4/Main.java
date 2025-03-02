package Multi_Threading.Midterm_Review.Activity4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean found = false;
    static ArrayList<Thread> threads;
    static String password;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter password: ");
        password = scan.nextLine();
        threads = new ArrayList<>(password.length());

        char[] vowel = {'a','e','i','o','u'};
        int id = 0;
        for(int i = 0; i < password.length(); i++){
            for(char c: vowel){
                threads.add(new Thread(new DecoderThread(c,i,password.length(), ++id)));
            }
        }

        for(int i = 0; i < threads.size(); i++){
            threads.get(i).start();
        }

    }
}
