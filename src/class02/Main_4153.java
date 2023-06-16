package class02;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_4153 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] exit = {"0", "0", "0"};

        while (true){
            var input = br.readLine().split(" ");
            int[] parseList = new int[input.length];

            if (Arrays.equals(input, exit)){
                break;
            }
            else{
                //피타고라스 공식 적용
                for (int i=0; i< input.length; i++){
                    parseList[i] = Integer.parseInt(input[i]);
                }
//                longLine = Arrays.stream(parseList).max().getAsInt();
//                System.out.println(longLine);
//                System.out.println(Arrays.toString(parseList));
                Arrays.sort(parseList);
                var tem1 = (parseList[0] * parseList[0]) + (parseList[1] * parseList[1]);
                var tem2 = parseList[2] * parseList[2];

                if (tem1 == tem2){
                    bw.write("right"+"\n");
                }else{
                    bw.write("wrong"+"\n");
                }
            }

        }
        bw.flush();
        bw.close();
    }
}
