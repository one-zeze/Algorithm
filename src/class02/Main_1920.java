package class02;

import java.awt.image.RGBImageFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        var N_List = br.readLine().split(" ");
        int[] parsingN = new int[N];
        for (int i=0; i<N; i++){
            parsingN[i] = Integer.parseInt(N_List[i]);
        }
        // N리스트 정렬
        Arrays.sort(parsingN);

        int M = Integer.parseInt(br.readLine());
        var M_List = br.readLine().split(" ");

        int start = 0;
        int end = N-1;
        int mid = (start + end)/2;
        int index = 0;
        while (index<M){
            int num = Integer.parseInt(M_List[index]);
            if (mid > M-1){
                sb.append(0).append("\n");
                mid = (start + end)/2;
                index++;
                continue;
            }

            if (num == parsingN[mid]){
                sb.append(1).append("\n");
                index++;
                mid = (start + end)/2;
                continue;
            }

            if (num > parsingN[mid]){
               mid++;
               continue;
            }

            if (num < parsingN[mid]){
                mid--;
                continue;
            }
        }

        System.out.println(sb);
    }
}
