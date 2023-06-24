package class02;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] inputList = new int[num];

        for (int i=0; i<num; i++){
            inputList[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputList);

        StringBuilder sb =new StringBuilder();
        for(int value : inputList) {
            sb.append(value).append('\n');
        }
        System.out.print(sb);

//        for (var item:inputList){
//            bw.write(item+"\n");
//        }
//        bw.flush();
//        bw.close();
    }
}