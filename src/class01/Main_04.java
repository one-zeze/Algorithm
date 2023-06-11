package class01;

import java.util.Scanner;

// 1.컴퓨터마다 6자리의 고유번호를 가짐
// 2.고유번호 첫 4자리는 00000~99999, 마지막은 검증수
// 검증수: 처음 5자리를 각각 제곱하여 더하고 10으로 나눈 나머지
// Input: 처음 5자리, Output: 검증수


public class Main_04 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		var sum = 0;
		
		for(int i=1; i<=5; i++) {
			var input_num = scan.nextInt();
			System.out.println(i+"자리 값: "+input_num);
			
			sum += input_num * input_num;
			System.out.println(sum);
			
		}
		
		System.out.println(sum%10);
	}
}
