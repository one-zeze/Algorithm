package class01;

import java.util.Scanner;

public class Main_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.println("a입력: ");
		int a = scan.nextInt();
		System.out.println("b입력: ");
		int b = scan.nextInt();
		
		
		var result = (double)a/b;
		System.out.println(result);
		/* double이 a,b에 둘다 적용됨 */
		
		var result2 = (double)a / (double)b;
		System.out.println(result2);
	}

}
