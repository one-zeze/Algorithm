package class03;

import java.util.Scanner;

public class Main_11727 {
    static Integer[] dp = new Integer[1001];

    public static void main(String[] args){
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // N=3 -> 5
        // N=4 -> 11
        // f(N) = f(N-1) + 2*f(N-2)

        int result = solve(N);
        System.out.println(result);
    }

    public static int solve(int N){
        if (dp[N] == null){
            dp[N] = (solve(N-1) + 2*solve(N-2))%10007;
        }

        return dp[N];
    }
}
