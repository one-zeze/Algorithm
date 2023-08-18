package class03;

import java.util.Scanner;

public class Main_17626 {
    static Integer[] Square = new Integer[50001];

    public static void main(String[] args){
        Square[0]=0;
        Square[1]=1;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1<= N <=50,000
        //라그랑주 네제곱수
        // N   dp[N]
        // 1 -> 1
        // 2 -> 2
        // 3 -> 3
        // 4 -> 1
        // 5 -> 2
        // 6 -> 3
        // 7 -> 4
        // 8 -> 2
        // 9 -> 1
        // dp[N] = dp[N-N이하의 제곱수] + 1;

        if (Square[N] == null){
            solve(N);
        }
        System.out.println(Square[N]);
    }

    public static void solve(int n){

        for (int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;

            for (int j=1; j*j<=i; j++){
                min = Math.min(min, Square[i-j*j]);
            }
            Square[i] = min+1;
        }
    }
}
