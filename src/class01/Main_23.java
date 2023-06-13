package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_23 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] newList = new int[num];

        var inputList = br.readLine().split(" ");
        for (int i=0; i<num; i++){
            newList[i] = Integer.parseInt(inputList[i]);
        }

        System.out.println(Arrays.stream(newList).min().getAsInt()+" "+Arrays.stream(newList).max().getAsInt());
    }
}
