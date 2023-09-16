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
    private static boolean[][] visit;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //col
        maze = new Integer[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++){
            String[] input = br.readLine().split("");
            for (int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        // input end
        bfs(new Coor(1, 1), new Coor(N, M));
        System.out.println(maze[N][M]);
    }

    private static void bfs(Coor start, Coor end){
        Queue<Coor> queue = new LinkedList<>();
        int x = start.x;
        int y = start.y;
        visit[x][y] = true;
        queue.offer(start);

        int[] moveX = {1,-1,0,0};
        int[] moveY = {0,0,1,-1};
        while (!queue.isEmpty()){
            Coor crt_coor = queue.poll();
            int coorVal = maze[crt_coor.x][crt_coor.y]+1;

            for (int i=0; i<4; i++){
                int newX = crt_coor.x+moveX[i];
                int newY = crt_coor.y+moveY[i];

                if (newX>0 && newX<=N && newY>0 && newY<=M){
                    if (!visit[newX][newY] && maze[newX][newY]!=0){
                        queue.offer(new Coor(newX, newY));
                        visit[newX][newY] = true;
                        maze[newX][newY] = coorVal;
                    }
                }
            }
        }

    }

}
