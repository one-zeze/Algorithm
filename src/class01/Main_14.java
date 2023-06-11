package class01;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main_14 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int score_num = sc.nextInt();
        int[] score_list = new int[score_num];
        int max = 0;
        double sum = 0;

        for (int i=0; i<score_num; i++){
            score_list[i] = sc.nextInt();
            if (score_list[i] > max){
                max = score_list[i];
            }
        }

        for (int i=0; i<score_num; i++){
            sum += (double)score_list[i] / max * 100;
        }

        System.out.println(sum/score_num);
    }
}
