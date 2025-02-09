package LinkedList_Generic_Classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scan = new Scanner(System.in);

        char option;
        int num, pos;

        do {
            System.out.print("Enter option: ");
            option = scan.next().charAt(0);

            switch(option) {
                case 'a':
                    System.out.print("Enter number: ");
                    num = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    list.add(num);
                    break;
                case 's':
                    System.out.print("Enter number: ");
                    num = scan.nextInt();

                    System.out.print("Enter pos: ");
                    pos = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    list.set(num, pos); // Assuming set(position, value)
                    break;
                case 'p':
                    list.print();
                    break;
            }
        } while(option != 'x');

        scan.close();
    }
}
