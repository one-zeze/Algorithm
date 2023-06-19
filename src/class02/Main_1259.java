package class02;

import java.io.*;

public class Main_1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            var input = br.readLine().split("");
            int len = input.length;
            String result = "yes";

            if (input[0].equals("0")){
                break;
            }

            for (int i=0; i< len; i++){
                var firstWord = input[i];
                var lastWord = input[len-1-i];

                if (! firstWord.equals(lastWord)){
                    result = "no";
                    break;
                }
//                System.out.println(firstWord+", "+lastWord);
            }
//            System.out.println();
            bw.write(result+"\n");

        }
        bw.flush();
        bw.close();
    }
}
