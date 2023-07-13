package class02;

import java.util.Scanner;

public class Main_2839 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int small = 3;
        int big = 5;
        int cnt = 0;

        while (N > 0){
            if (N%big == 0){
                cnt += N/big;
                N%=big;
            }
            else if (N>=small) {
                N -= small;
                cnt++;
            }
            else {
                cnt = -1;
                break;
            }


        }
        System.out.println(cnt);
    }
}
