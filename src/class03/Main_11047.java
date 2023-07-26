package class03;

import java.util.Scanner;

public class Main_11047 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coin = new int[N];
        for (int i=0; i<N; i++){
            coin[i] = sc.nextInt();
        }

        int cnt=0;
        for (int c=(N-1); c>=0; c--){
            cnt += K/coin[c];
            K %= coin[c];

            if (K==0){
                break;
            }
        }
        System.out.println(cnt);
    }
}
