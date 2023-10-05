package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {
    private static int[][] board;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //row
        M = Integer.parseInt(st.nextToken()); //col

        board = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int row=0; row<N; row++){
            for (int col=0; col<M; col++){
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve();
        System.out.println(result);
    }// main method
    private static int block1(int x, int y){
        // 1자 블록
        int sum = 0;
        int[] straight_x = {0,1,2,3};

        for (int i=0; i<4; i++){
            int newX = x+straight_x[i];
            if (newX>N){
                return 0;
            }
            sum += board[newX][y];
        }

        return sum;
    }
    private static int block2(int x, int y){
        // 정사각형 블록
        int sum = 0;
        int[] square_x = {0,1,0,1};
        int[] square_y = {0,0,1,1};
        for (int i=0; i<4; i++){
            int newX = x+square_x[i];
            int newY = y+square_y[i];

            sum += board[newX][newY];
        }

        return sum;
    }
    private static int block3(int x, int y){
        // L자 블록
        int sum = 0;
        int[] stickL_x = {0,0,0,1};
        int[] stickL_y = {0,1,2,2};
        for (int i=0; i<4; i++){
            int newX = x+stickL_x[i];
            int newY = y+stickL_y[i];
            sum += board[newX][newY];
        }

        return sum;
    }
    private static int block4(int x, int y){
        // 번개 블록
        int sum = 0;
        int[] thunder_x = {0,0,1,1};
        int[] thunder_y = {0,1,1,2};
        for (int i=0; i<4; i++){
            int newX = x+thunder_x[i];
            int newY = y+thunder_y[i];
            sum += board[newX][newY];
        }

        return sum;
    }
    private static int block5(int x, int y){
        // ㅗ블록
        int sum = 0;
        int[] fyou_x = {0,1,1,2};
        int[] fyou_y = {0,0,1,0};
        for (int i=0; i<4; i++){
            int newX = x+fyou_x[i];
            int newY = y+fyou_y[i];
            sum += board[newX][newY];
        }

        return sum;
    }
    private static int solve(){
        // 각 시작점에서 도형별로 값 계산후, 최대값 갱신
        // -> 블록 회전이랑 대칭은?,,,.,.
        // row 최대 4칸, col 최대 4칸
        // 블록 최대값 -> 가로4, 세로4 (회전 포함)
        int max=0;
        for (int row=0; row<N; row++){
            for (int col=0; col<M; col++){

            }
        }


        return 0;
    }
}
