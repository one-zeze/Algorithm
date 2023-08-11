package class03;

import java.util.Scanner;

public class Main_9461 {
    static Long[] dp = new Long[102];

    public static void main(String[] args){
        dp[1]=dp[2]=dp[3]=1L;
        dp[4]=dp[5]=2L;
        dp[6]=3L;
        dp[7]=4L;
        dp[8]=5L;
        dp[9]=7L;
        dp[10]=9L;

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            int N = sc.nextInt();
            if (N<=3){
                sb.append(1).append("\n");
            }else{
                sb.append(solve(N)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static Long solve(int N){
        // 2,3,4,5,7,9,12,16,21,28 -> N = (N-2)+(N-3)
        if (dp[N] == null){
            dp[N] = solve(N-2) + solve(N-3);
        }

        return dp[N];
    }
}
