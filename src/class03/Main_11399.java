package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var time = br.readLine().split(" ");

        int reulst = getShortest(N, time);
        System.out.println(reulst);
    }

    static int getShortest(int N, String[] input){
        //parse to int
        List<Integer> parsingList = new ArrayList<>();
        for (int i=0; i<N; i++){
            parsingList.add(Integer.parseInt(input[i]));
        }
        Collections.sort(parsingList);

        int total = 0;
        int idx = 0;
        for (var index:parsingList){
            idx += index;
            total += idx;
        }

        return total;
    }
}
