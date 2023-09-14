package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소경로 문제 (BFS)
public class Main_2178 {
    private static Integer[][] maze;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new Integer[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++){
            String[] input = br.readLine().split("");
            for (int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        // input end
        for (var c:maze){
            for (var r:c){
                System.out.print(r+" ");
            }
            System.out.println();
        }

    }

    private static int bfs(int start_x, int start_y){
        Queue<Integer> queue = new LinkedList<>();
        visit[start_x][start_y] = true;
        // node class?....need??

        int count=0;


        return count;
    }
}
