package class_1;

import java.util.*;
public class Main_05 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		var dan = scan.nextInt();
		
		for(int i=1; i<=9; i++) {
			var sum = dan*i;
			
			System.out.println(dan+" * "+i+" = "+sum);
		}
	}
}
