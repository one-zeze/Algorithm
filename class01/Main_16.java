package class01;

import java.util.Arrays;
import java.util.Scanner;

public class Main_16 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] result = new int[26];
        int count = 0;

        for(char i='a'; i<='z'; i++){
            String alpah = String.valueOf(i);
            if (word.contains(alpah)){
                var val = word.indexOf(alpah);
                result[count] = val;
                count++;
            }else {
                result[count] = -1;
                count++;
            }
        }

        for (int i : result){
            System.out.print(i+" ");
        }
    }
}
