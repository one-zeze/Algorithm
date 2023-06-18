package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var dealer = br.readLine().split(" ");
        var cardList = br.readLine().split(" ");
        int M = Integer.parseInt(dealer[1]);

        getMax(M, cardList);
    }

    public static void getMax(int max, String[] cardList){

        int len = cardList.length;
        int[] newList = new int[len];
        //정수 배열로 바꾸기
        for (int i=0; i<len; i++){
            newList[i] = Integer.parseInt(cardList[i]);
        }
        //최대합 구하기
        int sum = 0;
        int maxSum = 0;

        for (int i=0; i<len; i++){
            for (int j=i+1; j<len; j++){
                for (int z=j+1; z<len; z++){

                    sum = newList[i]+newList[j]+newList[z];
                    if (sum == max){
                        System.out.println(sum);
                        return;
                    }

                    if (sum<max && sum > maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}
