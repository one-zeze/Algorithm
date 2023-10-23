package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15654 {
    static int[] numbers;
    static int[] stack;
    static boolean[] visit;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        stack = new int[M];
        numbers = new int[N];
        visit = new boolean[N];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);
        dfs(0);

        System.out.print(sb);
    }//main
    static void dfs(int cnt){
        if (cnt==M){
            for (var idx:stack){
                sb.append(idx+" ");
            }
            sb.append("\n");
            return;
        }

       for (int i=0; i<N; i++){
           if (!visit[i]){
               visit[i] = true;
               stack[cnt] = numbers[i];
               dfs(cnt+1);
               visit[i] = false;
           }
       }
    }
}
