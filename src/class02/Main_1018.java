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

        //입력값 배열에 채우기
        String[][] board = new String[N][M];
        for (int i=0; i<N; i++){
            var input = br.readLine().split("");
            for (int j=0; j<M; j++){
                board[i][j] = input[j];
            }
        }

        // [0][0] = [0][1]이면 [0][0],[1][0]비교
        // [0][0] = [1][0]이면 [0][0]색칠 -> 다르면 [0][1]색칠
        // 한줄씩 입력받으면서 가장 적게 색칠해도 되는 8칸을 구해야함

        int num = 0;
        int num1 = 0;
        while (num<N && num1<M){
            int cnt = 0;
            for (int row=num; row<8; row++){
                for (int colunm=num1; colunm<8; colunm++){
                    String color = board[row][colunm];

                    if (colunm<M-1 && color.equals(board[row][colunm+1])){

                        if (row<N-1 && color.equals(board[row+1][colunm])){
                            cnt++;
                            if (color.equals("B")){
                                board[row][colunm] = "W";
                            }else{
                                board[row][colunm] = "B";
                            }
                        }
                    }
                }
                System.out.println(cnt);
            }
            num++;
            num1++;
//            System.out.println(cnt);
        }

    }
}
