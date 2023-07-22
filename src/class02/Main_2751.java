package class02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2751 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();

        for (int i=0; i<N; i++){
            numList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numList);

        for (var index:numList){
            bw.write(index+"\n");
        }
        bw.flush();
        bw.close();
    }
}
