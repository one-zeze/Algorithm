package class01;

import java.util.Scanner;

public class Main_12 {
    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextInt()){
            int a = scan.nextInt();
            int b = scan.nextInt();

            System.out.println(a*b);
        }

    }
}