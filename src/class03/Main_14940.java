package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
    private static int N, M;
    private static Integer[][] map;
    private static boolean[][] visit;
    private static Coor destination;
    private static class Coor{
        int x;
        int y;
        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //col

        map = new Integer[N+1][M+1];
        visit = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=1; j<=M; j++){
                int num = Integer.parseInt(st.nextToken());
                if (num==2){
                    destination = new Coor(i,j);
                }
                map[i][j] = num;
            }
        }
     // input endpoint
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++){
            for (int j=1; j<=M; j++){
                if (!visit[i][j] && map[i][j]==1){
//                    System.out.print(-1+" ");
                    sb.append(-1+" ");
                }else{
//                    System.out.print(map[i][j]+" ");
                    sb.append(map[i][j]+" ");
                }
            }
//            System.out.println();
            sb.append("\n");
        }
        System.out.println(sb);
    }//main

    private static void bfs(){
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(destination);
        visit[destination.x][destination.y] = true;
        map[destination.x][destination.y] = 0;
        int[] move_x = {-1,1,0,0};
        int[] move_y = {0,0,-1,1};

        while (!queue.isEmpty()){
            Coor crt = queue.poll();

            for (int i=0; i<4; i++){
                int new_x = crt.x + move_x[i];
                int new_y = crt.y + move_y[i];
                if (new_x>0 && new_x<=N && new_y>0 && new_y<=M){
                    if (!visit[new_x][new_y] && map[new_x][new_y]==1){
                        queue.offer(new Coor(new_x, new_y));
                        visit[new_x][new_y] = true;
                        map[new_x][new_y] = map[crt.x][crt.y]+1;
                    }
                }
            }//for
        }//while
    }
}
// StringBuilder 유무 1700ms 차이