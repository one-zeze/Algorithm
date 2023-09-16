package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소경로 문제 (BFS)
class Coor{
    public int x;
    public int y;

    public Coor(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main_2178 {
    private static Integer[][] maze;
    private static Integer[][] visit;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new Integer[N+1][M+1];
        visit = new Integer[N+1][M+1];

        for (int i=1; i<=N; i++){
            String[] input = br.readLine().split("");
            for (int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        // input end
        bfs(new Coor(1, 1), new Coor(N, M));
        System.out.println(visit[N][M]);
    }

    private static void bfs(Coor start, Coor end){
        Queue<Coor> queue = new LinkedList<>();
        int x = start.x;
        int y = start.y;
        int count = 1;
        visit[x][y] = count;
        queue.offer(start);

        int[] moveX = {1,-1,0,0};
        int[] moveY = {0,0,1,-1};
        while (!queue.isEmpty()){
            Coor crt_coor = queue.poll();

        }

    }

}
