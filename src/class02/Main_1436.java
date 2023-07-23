package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int movie_num = 666;

        int count = 1;
        while (count != N){
            movie_num++;
            String str = String.valueOf(movie_num);
            if (str.contains("666")){
                count++;
            }
        }
        System.out.println(movie_num);
    }
}
