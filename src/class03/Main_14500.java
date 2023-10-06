package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //col

        board = new int[N][M];
        visit = new boolean[N][N];
        for (int row=0; row<N; row++){
            st = new StringTokenizer(br.readLine(), " ");
            for (int col=0; col<M; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                solve(new Coor(i, j));
            }
        }
        System.out.println(max);
//        solve(new Coor(2,4));
    }// main method
    private static void solve(Coor start){
        // 각 시작점에서 도형별로 값 계산후, 최대값 갱신
        // -> 블록 회전이랑 대칭은?,,,.,.
        // row 최대 4칸, col 최대 4칸
        // 블록 최대값 -> 가로4, 세로4 (회전 포함)

        // 시작점부터 거쳐가는 모든 블록에 붙어있는 블록들의 값을 우선순위 큐에 넣고
        // 큰값을 위주로 탐색하다가, 같은 값/작은값에 둘러 쌓여있으면 우선순위 큐에 값이랑
        // 비교해서 더하기?,,
        // 각도형을 첫번째 블록으로 가정한 경우, 모든 노드 블록별로 탐색가능함
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[0][0] = true;
        int[] moveX = {0,1,2,3,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,-1,0,1,2,2,0,1,2,2,0,0,0,1,
        0,0,0,-1,0,-1,-2,-2,0,-1,-2,-2,0,0,1,1,0,0,-1,-1,0,1,1,2,0,1,1,2,
        0,0,-1,-1,0,0,1,1,0,-1,-1,-2,0,-1,-1,-2,0,1,1,2,0,1,1,2,0,0,1,0,0,0,-1,0};
        int[] moveY = {0,0,0,0,0,1,2,3,0,0,1,1,0,1,2,2,0,1,2,2,0,0,0,1,0,0,0,-1,0,-1,-2,-2,
        0,-1,-2,-2,0,0,0,1,0,0,0,-1,0,1,1,2,0,1,1,2,0,0,-1,-1,0,0,1,1,
        0,-1,-1,-2,0,-1,-1,-2,0,0,1,1,0,0,-1,-1,0,0,1,0,0,0,-1,0,0,1,1,2,0,1,1,2};

        while (!queue.isEmpty()){
            Coor crt = queue.poll();

            for (int i=0; i<moveX.length-4; i+=4){
                int sum = 0;
                for (int j=i; j<i+4; j++){
                    int newX = crt.x + moveX[j];
                    int newY = crt.y + moveY[j];
                    if (newX<0 || newX>=N || newY<0 || newY>=M){
                        sum=0;
                        break;
                    }
                    sum += board[newX][newY];
                }
                if (sum>max){ //블록 최대값 갱신
                    max = sum;
//                    System.out.println(max);
                }
            }

        }

    }
}
