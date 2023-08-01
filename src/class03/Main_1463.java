package class03;

import java.util.Scanner;

public class Main_1463 {
    static Integer[] dp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        int result = dynamic(N);
        System.out.println(result);

    }

    static int dynamic(int n){
        if(dp[n] == null) {
            if(n%6 == 0) {
                dp[n] = Math.min(dynamic(n-1), Math.min(dynamic(n/3), dynamic(n/2))) + 1;
            } else if(n%3 == 0) {
                dp[n] = Math.min(dynamic(n/3), dynamic(n-1)) + 1;
            } else if(n%2 == 0) {
                dp[n] = Math.min(dynamic(n/2), dynamic(n-1)) + 1;
            } else {
                dp[n] = dynamic(n-1) + 1;
            }
        }
        return dp[n];
    }
}
