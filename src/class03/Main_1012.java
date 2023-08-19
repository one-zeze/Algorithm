package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1012 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //test case

        while (T-- > 0){
            String[] size = br.readLine().split(" ");
            int M = Integer.parseInt(size[0]); //가로
            int N = Integer.parseInt(size[1]); //세로
            int K = Integer.parseInt(size[2]); //배추 개수

            boolean[][] cabbage = new boolean[M][N]; //배추밭
            while (K-->0){
                String[] position = br.readLine().split(" ");
                cabbage[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = true;
            }

            int result = worm(cabbage);
        }

    }

    public static int worm(boolean[][] field){
        

        return 0;
    }
}
