package class03;

import java.util.Scanner;

public class Main_11726 {
    static Integer[] dp = new Integer[1001];

    public static void main(String[] args){
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        // n=1 -> 1가지
        // n=2 -> 2가지
        // n=3 -> 3가지
        // n=4 -> 5가지
        // n=5 -> 8가지
        // f(n) = f(n-1) + f(n-2) 피보나치

        System.out.println(solution(N));
    }

    public static int solution(int n){
//        if (n<3){
//            return n;
//        }

        if (dp[n] == null){
            dp[n] = (solution(n-1) + solution(n-2))%10007;
        }

        return dp[n];
    }
}
