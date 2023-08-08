package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2606 {
    static int[][] arr;
    static boolean[] visit;
    static int cnt = 0;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //컴퓨터수
        int connect = Integer.parseInt(br.readLine()); //직접 연결된 컴퓨터 수

        arr = new int[N+1][N+1];
        visit = new boolean[N+1];

        while (connect-- > 0){
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int start){
        visit[start] = true;

        for (int i=1; i<=N; i++){
            if (arr[start][i]==1 && visit[i]==false){
                cnt++;
                dfs(i);
            }
        }
    }

//    public static void bfs(int start){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(start);
//        visit[start] = true;
//
//        while (!queue.isEmpty()){
//            int temp = queue.poll();
//
//            for (int i=1; i<=N; i++){
//                if (arr[temp][i]==1 && visit[i]==false){
//                    queue.offer(i);
//                    visit[i] == true;
//                    cnt++;
//                }
//            }
//        }
//    }

}