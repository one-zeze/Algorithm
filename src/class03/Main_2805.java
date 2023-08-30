package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int treeNum = Integer.parseInt(st.nextToken());
        int treeLen = Integer.parseInt(st.nextToken());

        int[] tree =  new int[treeNum];
        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<treeNum; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            
            // max값 = 가장 큰나무
            if (max < tree[i]){
                max = tree[i];
            }
        }

        while (min<max){
            int mid = (min+max)/2; //톱날 높이
            long sum = 0;

            for (int t:tree){
                if (t-mid > 0){ //나무가 톱날보다 높으면 자름
                    sum+=(t-mid);
                }
            }

            if (sum < treeLen){ //합이 M보다 작으면, 톱날높이 감소
                max = mid;
            }
            else{ // 합이 M보다 크므로, 톱날높이 증가
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
