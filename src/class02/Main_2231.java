package class02;

import java.util.Scanner;

public class Main_2231 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //생성자가 없는 경우 0출력
        int result = 0;

        for (int i=0; i<N; i++){
            int num = i;
            int sum = 0;

            while (num != 0){
                sum += num%10;
                num = num/10;

            }

            if (sum+i == N){
//                System.out.println("sum: %d, num: %d, i: %d".formatted(sum, num, i));
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
