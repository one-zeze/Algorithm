package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2630 {
    static int white = 0;
    static int blue = 0;
    static String[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new String[N][N];

        for (int i=0; i<N; i++){
            paper[i] = br.readLine().split(" ");

        }

        solve(0, 0, N);
        System.out.println(white+"\n"+blue);
    }

    public static void solve(int row, int col, int size){

        if (colorCheck(row, col, size)){
            if (paper[row][col].equals("0")){
                white++;
            }
            else{
                blue++;
            }
            return;
        }

        int partiation = size/2;
        solve(row, col, partiation); //2사분면
        solve(row+partiation, col, partiation); //3사분면
        solve(row, col+partiation, partiation); //1사분면
        solve(row+partiation, col+partiation, partiation); //4사분면

    }

    public static boolean colorCheck(int row, int col, int size){
        String color = paper[row][col]; //첫 번째 index 값

        for (int i=row; i<row+size; i++){
            for (int j=col; j<col+size; j++){

                if (!paper[i][j].equals(color)){ //색이 다르면 false 리턴
                    return false;
                }
            }
        }
        
        return true; //색이 같음
    }
}
