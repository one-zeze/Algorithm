package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15666 {
    static int N, M;
    static Integer[] arr, result;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        arr = new Integer[N];
        result = new Integer[M];

        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        //input end
        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0,0);

        System.out.println(sb);
    }//maindd
    private static void dfs(int idx, int len){
        if (len == M){
            for (int i:result){
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i=idx; i<N; i++){
            if (arr[i] == prev){
                continue;
            }
            result[len] = prev = arr[i];
            dfs(i,len+1);
        }
    }
}
