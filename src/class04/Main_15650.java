package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }//main
    static void dfs(int start, int depth){

        if (depth==M){
            for (int val:arr){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<=N; i++){
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
