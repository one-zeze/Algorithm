package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1018 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        String[] board = new String[N];

        // 입력값으로 배열 생성
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }

        int max_row = N - 8;
        int max_col = M - 8;
        int result = Integer.MAX_VALUE;
        for (int r = 0; r <= max_row; r++) {
            for (int c = 0; c <= max_col; c++) {

                int new_result = solution(r, c, board);
                //최소값으로 갱신
                if (new_result < result) {
                    result = new_result;
                }
            }
        }
        System.out.println(result);
    }

    // 8*8자른 보드를 체스판으로 만들기 위해 색칠해야 하는 개수 구하기
    public static int solution(int r, int c, String[] board) {
        String[] chessBoard = {"WBWBWBWB", "BWBWBWBW"};
        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int row = i+r;

            for (int j = 0; j < 8; j++) {
                int col = j+c;

                if (board[row].charAt(col) != chessBoard[i%2].charAt(j)){
                    cnt++;
                }
            }
        }
        return Math.min(cnt, 64-cnt);
    }
}
