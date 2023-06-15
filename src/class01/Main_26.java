package class01;

import java.util.Arrays;
import java.util.Scanner;

public class Main_26 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] numList = new int[9];

        for (int i=0; i<9; i++){
            numList[i] = sc.nextInt();
        }

        int max = Arrays.stream(numList).max().getAsInt();
        int index = 1;
        for (var item:numList){
            if (item == max){
                break;
            }else {
                index++;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
