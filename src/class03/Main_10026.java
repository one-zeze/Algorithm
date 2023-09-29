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
    private static String[][] colorGrid, rgGrid;
    private static boolean[][] visit;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colorGrid = new String[N][N];
        rgGrid = new String[N][N];
        visit = new boolean[N][N];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for (int j=0; j<N; j++){
                colorGrid[i][j] = input[j];
                if (input[j].equals("R")){
                    rgGrid[i][j]="G";
                }else{
                    rgGrid[i][j] = input[j];
                }
            }
        }
        //input end
        int normal=0;
        int redGreen=0;

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visit[i][j]){
                    bfs(new Coor(i,j));
                    normal++;
                }
            }
        }//normal
        visit = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!visit[i][j]){
                    rg_bfs(new Coor(i,j));
                    redGreen++;
                }
            }
        }//redGreen

        System.out.println(normal+" "+redGreen);
    }//main method

    private static void bfs(Coor start){
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()){
            Coor crt = queue.poll();
            String crt_color = colorGrid[crt.x][crt.y];

            for (int i=0; i<4; i++){
                int newX = crt.x + move_x[i];
                int newY = crt.y + move_y[i];
                if (newX>=0 && newX<N && newY>=0 && newY<N){
                    String next_color = colorGrid[newX][newY];

                    if (!visit[newX][newY] && crt_color.equals(next_color)){
                        visit[newX][newY] = true;
                        queue.offer(new Coor(newX,newY));
                    }
                }
            }
        }
    }

    private static void rg_bfs(Coor start){
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()){
            Coor crt = queue.poll();
            String crt_color = rgGrid[crt.x][crt.y];

            for (int i=0; i<4; i++){
                int newX = crt.x + move_x[i];
                int newY = crt.y + move_y[i];
                if (newX>=0 && newX<N && newY>=0 && newY<N){
                    String next_color = rgGrid[newX][newY];

                    if (!visit[newX][newY] && crt_color.equals(next_color)){
                        visit[newX][newY] = true;
                        queue.offer(new Coor(newX,newY));
                    }
                }
            }
        }
    }
}//Main Class
