package class01;

import java.util.Scanner;

public class Main_02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num_1 = scan.nextInt();
		int num_2 = scan.nextInt();
		
		if(num_1 == num_2) {
			System.out.println("==");
		}
		else if(num_1 < num_2) {
			System.out.println("<");
		}
		else {
			System.out.println(">");
		}
			
	}
}
