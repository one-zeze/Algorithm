package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7569 {
    private static Integer[][][] tomato;
    private static boolean[][][] visit;
    private static class coor{
        int h;
        int n;
        int m;
        public coor(int h, int n, int m){
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
    private static int M, N, H;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);
        H = Integer.parseInt(size[2]);

        tomato = new Integer[H][N][M];
        visit = new boolean[H][N][M];

        int a,b,c; //bfs 시작점
        a=b=c=0;
        boolean isRipe = true; // 모든 토마토가 익은 경우
        boolean noRipe = true; // 익은 토마토가 없는 경우
        for (int h=0; h<H; h++){ //층
            for (int n=0; n<N; n++){ //세로
                String[] input = br.readLine().split(" ");

                for (int m=0; m<M; m++){ //가로
                    int t_status = Integer.parseInt(input[m]);
                    tomato[h][n][m] = t_status;
                    if (t_status==0){
                        isRipe = false;
                    }
                    if (t_status==1){
                        noRipe = false;
                        a=h;
                        b=n;
                        c=m;
                    }
                }
            }
        }
        if (isRipe && !noRipe){ // 0이 하나도 없는 경우
            System.out.println(0);
        } 
        else if (!isRipe && noRipe) { // 1이 하나도 없는 경우
            System.out.println(-1);
        }
        else{
            for (int h=0; h<H; h++){ //층
                for (int n=0; n<N; n++){ //세로
                    for (int m=0; m<M; m++){ //가로
                        if (tomato[h][n][m]==0){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }
            System.out.println(bfs(new coor(a, b, c)));
        }

    }//main

    private static int bfs(coor start){
        Queue<coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.h][start.n][start.m] = true;

        int[] move_h = {1, -1, 0, 0, 0, 0};
        int[] move_x = {0, 0, -1, 1, 0, 0};
        int[] move_y = {0, 0, 0, 0, -1, 1};

        int days = 0;
        while (!queue.isEmpty()){
            coor crt = queue.poll();

            for (int i=0; i<6; i++){
                int newH = crt.h + move_h[i];
                int newN = crt.n + move_x[i];
                int newM = crt.m + move_y[i];

                if (newH>=0 && newH<H && newN>=0 && newN<N && newM>=0 && newM<M){
                    if (!visit[newH][newN][newM] && tomato[newH][newN][newM]==0){
                        days = tomato[newH][newN][newM] = tomato[crt.h][crt.n][crt.m]+1;
                        visit[newH][newN][newM] = true;
                        queue.offer(new coor(newH, newN, newM));
                    }
                }
            }
        }
        return days-1;
    }
}