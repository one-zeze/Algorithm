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

        for (int i=0; i<M; i++){
            int start = 0;
            int end = N-1;

            boolean notExist = true;
            //이분탐색
            while (start <= end){
                int num = Integer.parseInt(M_List[i]);
                int mid = (start + end)/2;

                if (num == parsingN[mid]){
                    notExist = false;
                    sb.append(1).append("\n");
                    break;
                }
                else if (num > parsingN[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            if (notExist){
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
