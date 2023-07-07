package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_18110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int opinion = Integer.parseInt(br.readLine());
        var excludeNum = Math.round(opinion*0.15);

        int[] inputList = new int[opinion];
        for (int i=0; i<opinion; i++){
            inputList[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(inputList);

        for (int j=0; j<excludeNum; j++){
            inputList[j] = 0;
            inputList[inputList.length-1-j] = 0;
        }

        System.out.println(getAvg(inputList));
    }

    private static Long getAvg(int[] numList){
        double sum=0;
        double div = 0;

        for (int index:numList){
            sum+=index;
            if (index != 0){
                div++;
            }
        }

        var avg = Math.round(sum/div);
        return avg;
    }
}
