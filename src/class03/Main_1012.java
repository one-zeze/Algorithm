package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1012 {
    static boolean[][] visit_dp;
    static boolean[][] cabbage;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //test case

        while (T-- > 0){
            String[] size = br.readLine().split(" ");
            int M = Integer.parseInt(size[0]); //가로
            int N = Integer.parseInt(size[1]); //세로
            int K = Integer.parseInt(size[2]); //배추 개수

            cabbage = new boolean[M][N]; //배추밭
            visit_dp = new boolean[M][N];
            for (int i=0; i<K; i++){
                String[] position = br.readLine().split(" ");
                cabbage[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = true;
            }

            int result = 0;
            if (K==1){
                result = 1;
            } else{
                result = worm();
            }

            System.out.println(result);
        }
    }

    public static int worm(){
        //첫배추에서 방문하지 않은 인접한 배추로 이동
        //이동한 배추에서 방문하지 않은 인접한 배추로 이동
        //반복
        //더이상 방문하지 않은 인접한 배추가 없으면, 벌레+1
        //배추방문 여부가 true로 바뀔때마다 K-1
        int cnt = 0;
        for (int i=0; i<cabbage.length; i++){
            for (int j=0; j< cabbage[i].length; j++){

                if (cabbage[i][j] && !visit_dp[i][j]){ //배추가 있는곳
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs(int x, int y){
        visit_dp[x][y] = true;
//        System.out.println("index (%d, %d)".formatted(x,y));
        int[] cx = {0,-1,0,1};
        int[] cy = {-1,0,1,0};

        for (int i=0; i<4; i++){
            int nx = x+cx[i];
            int ny = y+cy[i];

            if (nx>=0 && ny>=0 && nx<cabbage.length && ny<cabbage[0].length){
                if (!visit_dp[nx][ny] && cabbage[nx][ny]){
                    bfs(nx, ny);
                }
            }

        }
    }
}
