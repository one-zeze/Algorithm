package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//import java.util.LinkedList;
//import java.util.Queue;

public class Main_14500 {
    private static class Coor{
        int x;
        int y;
        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] board;
    private static boolean[][] visit;
    private static int N, M;
    private static int max = 0;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //col

        board = new int[N][M];
        visit = new boolean[N][M];

        for (int row=0; row<N; row++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int col=0; col<M; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        //input end
        //        bfs
//        for (int i=0; i<N; i++){
//            for (int j=0; j<M; j++){
//                solve(new Coor(i, j));
//            }
//        }
//        dfs
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                visit[i][j] = true;
                dfs(new Coor(i, j),board[i][j],1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }// main method
    private static void dfs(Coor start, int sum, int cnt){
        //최대값 갱신
        if (cnt == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<4; i++){
            int newRow = start.x + dx[i];
            int newCol = start.y + dy[i];
            // 범위 검증
            if (newRow<0 || newRow>=N || newCol<0 || newCol>=M){
                continue;
            }

            if (!visit[newRow][newCol]){
                // ㅗ 블록 값을 구하기 위해서, 2번째 칸에서 한번더 탐색
                if (cnt==2){
                    visit[newRow][newCol] = true;
                    dfs(start, sum+board[newRow][newCol], cnt+1);
                }
                
                visit[newRow][newCol] = true;
                dfs(new Coor(newRow, newCol), sum+board[newRow][newCol], cnt+1);
                visit[newRow][newCol] = false;
            }
        }
    }

    //bfs 실패, 백트랙킹 비효율적임
//    private static void solve(Coor start){
//        Queue<Coor> queue = new LinkedList<>();
//        queue.offer(start);
//        visit[0][0] = true;
//
//        int[] moveX = {0,1,2,3,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,-1,0,1,2,2,0,1,2,2,0,0,0,1,
//        0,0,0,-1,0,-1,-2,-2,0,-1,-2,-2,0,0,1,1,0,0,-1,-1,0,1,1,2,0,1,1,2,
//        0,0,-1,-1,0,0,1,1,0,-1,-1,-2,0,-1,-1,-2,0,1,1,2,0,1,1,2,0,0,1,0,0,0,-1,0};
//        int[] moveY = {0,0,0,0,0,1,2,3,0,0,1,1,0,1,2,2,0,1,2,2,0,0,0,1,0,0,0,-1,0,-1,-2,-2,
//        0,-1,-2,-2,0,0,0,1,0,0,0,-1,0,1,1,2,0,1,1,2,0,0,-1,-1,0,0,1,1,
//        0,-1,-1,-2,0,-1,-1,-2,0,0,1,1,0,0,-1,-1,0,0,1,0,0,0,-1,0,0,1,1,2,0,1,1,2};
//
//        while (!queue.isEmpty()){
//            Coor crt = queue.poll();
//
//            for (int i=0; i<moveX.length-4; i+=4){
//                int sum = 0;
//                for (int j=i; j<i+4; j++){
//                    int newX = crt.x + moveX[j];
//                    int newY = crt.y + moveY[j];
//                    if (newX<0 || newX>=N || newY<0 || newY>=M){
//                        sum=0;
//                        break;
//                    }
//                    sum += board[newX][newY];
//                }
//                if (sum>max){ //블록 최대값 갱신
//                    max = sum;
////                    System.out.println(max);
//                }
//            }
//
//        }
//    }
}
