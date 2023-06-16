package class01;

import java.io.*;

//백준 2439번 문제
public class Main_28 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());

        for (int i=1; i<=roop; i++){
            for (int j=(roop-i); j>0; j--){
                bw.write(" ");
            }

            for (int z=0; z<i; z++){
                bw.write("*");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
