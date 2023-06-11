package class01;

import java.io.*;

public class Main_20 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());


        for (int i=0; i<testCase; i++){
            var input = br.readLine().split(" ");

            int R = Integer.parseInt(input[0]);
            String S = input[1];
            StringBuilder sb = new StringBuilder();

            for (int j=0; j<S.length(); j++){

                for (int z=0; z<R; z++){
                    sb.append(S.charAt(j));
                }
            }

            bw.write(sb.toString()+"\n");
        }

        bw.flush();
        bw.close();
    }
}
