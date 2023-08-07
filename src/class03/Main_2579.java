package class03;

import java.util.Scanner;

public class Main_2579 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int stair = sc.nextInt();

        int[] DP = new int[stair+1];
        int[] arr = new int[stair+1];
        for (int i=1; i<=stair; i++){
            arr[i] = sc.nextInt();
        }

        DP[1] = arr[1];
        if (stair >= 2){
            DP[2] = arr[1]+arr[2];
        }

        for (int i=3; i<=stair; i++){
            int num1 = DP[i-3]+arr[i-1]+arr[i]; //마지막계단 이전계단을 밟은경우
            int num2 = DP[i-2]+arr[i]; // 마지막 이전계단을 밟지 않은경우
            DP[i] = Math.max(num1,num2);
        }

        System.out.println(DP[stair]);
    }
}
