package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_19 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var inputList = br.readLine().split( " ");
//        System.out.println(inputList.equals("1 2 3 4 5 6 7 8"));
        int[] parseList = new int[inputList.length];
        String result = "";

        for (int i=0; i< inputList.length; i++){
            parseList[i] = Integer.parseInt(inputList[i]);
        }

        for(int i=0; i< inputList.length-1; i++){

            if (parseList[i]+1 == parseList[i+1] && parseList[0] == 1){
                result = "ascending";
            } else if (parseList[i]-1 == parseList[i+1] && parseList[0] == 8) {
                result = "descending";
            }else{
                result = "mixed";
                break;
            }
        }
        System.out.println(result);

    }
}
