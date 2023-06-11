package class01;

import java.util.*;
public class Main_03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int roop = scan.nextInt();
		
		for(int i=1; i<=roop; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
