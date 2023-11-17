package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_15663 {
    private static StringBuilder sb;
    static int[] arr, result;
    static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); //수의 개수
        M = Integer.parseInt(input[1]); //수열 최대길이
        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];

        String[] nums = br.readLine().split(" ");
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(arr);

        sb = new StringBuilder();
        solution(-1, 0);

        System.out.print(sb);
    }//main

    static void solution(int idx, int cnt){
        if (cnt == M){
            for (int index:result){
                sb.append(index+" ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i=0; i<N; i++){
            if (visit[i]){
                continue;
            }
            if (prev != arr[i]){
                visit[i] = true;
                result[cnt] = arr[i];
                prev = arr[i];
                solution(i, cnt+1);
                visit[i] = false;
            }
        }
    }

}
