package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11053 {
    static Integer[] visit;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new Integer[N];
        String[] input = br.readLine().split(" ");

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        //end input
        //top-down
        for (int i=0; i<N; i++){
            LIS(i);
        }

        int max = visit[0];
        for (int i=1; i<N; i++){
            max = Math.max(max,visit[i]);
        }

        System.out.println(max);
    }//main
    static int LIS(int N) {

        // 만약 탐색하지 않던 위치의 경우 
        if(visit[N] == null) {
            visit[N] = 1;	// 1로 초기화 

            // N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출. 
            for(int i = N - 1; i >= 0; i--) {
                if(arr[i] < arr[N]) {
                    visit[N] = Math.max(visit[N], LIS(i) + 1);
                }
            }
        }
        return visit[N];
    }
}
