package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15657 {
    static int[] numbers;
    static int[] result;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        numbers = new int[N];
        result = new int[M];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);
        //end input
        dfs(0, 0);
        System.out.print(sb);
    }//main

    private static void dfs(int cnt, int crtIdx){
        if (cnt==M){
            for (int item:result){
                sb.append(item+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=crtIdx; i<N; i++){
            result[cnt] = numbers[i];
            dfs(cnt+1, i);
        }
    }
}
