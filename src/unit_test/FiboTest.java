package unit_test;

import java.util.Scanner;

public class FiboTest {
    static Integer[] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N+1];
        dp[1] = dp[2] = 1;

        int result = fibo(N);
        System.out.println(result);
    }

    static int fibo(int N){
        for (int i=3; i<=N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[N];
//        if (N<=2){return dp[N];}
//        if (dp[N]==null){
//            return dp[N] = fibo(N-1)+fibo(N-2);
//        }
//        return dp[N];
    }
}
