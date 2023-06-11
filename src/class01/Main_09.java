package class01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
//
//입력
//두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
//
//출력
//첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.

public class Main_09 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		var num_A = Integer.parseInt(st.nextToken());
		var num_B = Integer.parseInt(st.nextToken());
		
		if(inputValidation(num_A) && inputValidation(num_B)) {
			System.out.println(num_A+num_B);
			System.out.println(num_A-num_B);
			System.out.println(num_A*num_B);
			System.out.println(num_A/num_B);
			System.out.println(num_A%num_B);
			
		}else {
			return;
		}
		
	}

	public static Boolean inputValidation(int num) {
		
		if(num<1 || num>10000) {
			return false;
		}else {
			return true;
		}
	}
}
