package class03;

import java.io.*;

public class Main_9095 {
    static Integer[] dp = new Integer[12];

    public static void main(String[] args) throws IOException {
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
            bw.write(solve(N)+"\n");
        }

        bw.flush();
        bw.close();
    }

    public static int solve(int N){
        if (N==1){
            return 1;
        }
        if (N==2){
            return 2;
        }
        if (dp[N] == null){
            dp[N] = solve(N-1) + solve(N-2) + solve(N-3);
        }

        return dp[N];
    }
}
