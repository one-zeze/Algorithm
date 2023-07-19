package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_1018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        String[][] board = new String[N][M];

        // 입력값으로 배열 생성
        for (int i=0; i<N; i++){
            board[i] = br.readLine().split("");
        }

        int max_row = N-8;
        int max_col = M-8;

        for (int r=0; r<=max_row; r++){
            for (int c=0; c<=max_col; c++){
                String[][] chess = new String[8][8];

                for (int i=0; i<8; i++){
                    for (int j=0; j<8; j++){
                        chess[i][j] = board[i+r][j+c];
                    }
                }

                int cnt = color(chess);
//                System.out.println("row:%d~%d, col:%d~%d".formatted(r,r+8,c,c+8));
//                for (var item:chess){
//                    for (var item1:item){
//                        System.out.print(item1);
//                    }
//                    System.out.println();
//                }
            }
        }
    }
    // 8*8자른 보드를 체스판으로 만들기 위해 색칠해야 하는 개수 구하기
    public static int color(String[][] board){
        int start_B = 0;
        int start_W = 0;

        //B로 시작하는 경우
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                if (board[i][j].equals(board[i][j])){

                }
            }
        }

        return 0;
    }
}
