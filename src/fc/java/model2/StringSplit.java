package fc.java.model2;

import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        String[] strArray = str.split("\\s+");
        for(String s : strArray) {System.out.println(s);}

    }
}
