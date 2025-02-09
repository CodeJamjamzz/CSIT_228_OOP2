package Exceptions_Assertions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number: ");
        int i = scan.nextInt();
        scan.nextLine();

        try {
            System.out.println();
            throw new Error();
        } finally {
            System.out.println("can do");
        }

    }
}
