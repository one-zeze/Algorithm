package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652 {
    static Integer[][] arr;
    static int[] stack;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N+1][N+1];
        stack = new int[M];
        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int start, int cnt){
        if (cnt==M){
            for (var idx:stack){
                sb.append(idx+" ");
            }
            sb.append("\n");
            return;
        }

        for (int j=0; j<N; j++){
            if (start+j <= N){
                stack[cnt] = start+j;
                dfs(start+j, cnt+1);
            }
        }

    }
}
