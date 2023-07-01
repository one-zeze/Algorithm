package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test_1654 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] lenList = new int[K];
        for (int i=0; i<K; i++){
            int length = Integer.parseInt(br.readLine());
            lenList[i] = length;
        }

        while (true){
            int newLenght = Arrays.stream(lenList).max().getAsInt();

            for (int i=newLenght; i>0; i--){
                int cnt=0;
                for (var index:lenList){
                    cnt += index/i;
                }
                if (cnt >= N){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}