package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    private static class Coor{
        int x;
        int y;
        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static String[][] colorGrid;
    private static int[][] normal;
    private static boolean[][] visit;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colorGrid = new String[N+1][N+1];
        visit = new boolean[N+1][N+1];
        normal = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            colorGrid[i] = br.readLine().split("");
        }
        //input end
        bfs(new Coor(1, 1));

        for (var row:normal){
            for (var col:row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }//main method

    private static void bfs(Coor start){
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,0};
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;
        normal[start.x][start.y] = 1;

        while (!queue.isEmpty()){
            Coor crt = queue.poll();
            String crt_color = colorGrid[crt.x][crt.y];

            for (int i=0; i<4; i++){
                int newX = crt.x + move_x[i];
                int newY = crt.y + move_y[i];
                if (newX>=1 && newX<=N && newY>=1 && newY<=N){
                    String next_color = colorGrid[newX][newY];

                    if (!visit[newX][newY] && crt_color.equals(next_color)){
                        normal[newX][newY] = normal[crt.x][crt.y];
                        
                    }
                    else if (!visit[newX][newY] && !crt_color.equals(next_color)){
                        normal[newX][newY] = normal[crt.x][crt.y]+1;
                    }
                }
            }
        }
    }
}//Main Class
