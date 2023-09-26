package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7576 {
    private static Integer[][] tomato;
    private static boolean[][] visit;
    private static class coor{
        int n;
        int m;
        public coor(int n, int m){
            this.n = n;
            this.m = m;
        }
    }
    private static int M, N;
    private static Queue<coor> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);

        tomato = new Integer[N][M];
        visit = new boolean[N][M];

        boolean isRipe = false; // 모든 토마토가 익은 경우
        boolean noRipe = false; // 익은 토마토가 없는 경우
        for (int n=0; n<N; n++){ //세로
            String[] input = br.readLine().split(" ");

            for (int m=0; m<M; m++){ //가로
                int t_status = Integer.parseInt(input[m]);
                tomato[n][m] = t_status;
                if (t_status==0){
                    isRipe = true;
                }
                if (t_status==1){
                    noRipe = true;
                    queue.offer(new coor(n, m));
                    visit[n][m] = true;
                }
            }
        }
        //input end
        if (!isRipe && noRipe){ // 0이 하나도 없는 경우
            System.out.println(0);
        }
        else{
            int result = bfs();
            for (int n=0; n<N; n++){ //세로
                for (int m=0; m<M; m++){ //가로
                    if (tomato[n][m]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(result);
        }

    }//main

    private static int bfs(){
        int[] move_x = {-1, 1, 0, 0};
        int[] move_y = {0, 0, -1, 1};

        int days = 0;
        while (!queue.isEmpty()){
            coor crt = queue.poll();

            for (int i=0; i<4; i++){
                int newN = crt.n + move_x[i];
                int newM = crt.m + move_y[i];

                if (newN>=0 && newN<N && newM>=0 && newM<M){
                    if (!visit[newN][newM] && tomato[newN][newM]>=0){
                        days = tomato[newN][newM] = tomato[crt.n][crt.m]+1;
                        visit[newN][newM] = true;
                        queue.offer(new coor(newN, newM));
                    }
                }
            }
        }
        return days-1;
    }
}
