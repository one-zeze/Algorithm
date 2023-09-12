package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> timeMap = new HashMap<>();
        while (N-->0){
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if (timeMap.get(start) != null){
                int oldValue = timeMap.get(start);
                if (end<oldValue){
                    timeMap.put(start, end);
                }
            }else{
                timeMap.put(start, end);
            }
        }
        // input end
        // 회의시작 시간 리스트 변환후 정렬
        List<Integer> start  = new ArrayList<>(timeMap.keySet());
        Collections.sort(start);

        for (int k:start){
            System.out.print(timeMap.get(k)+" ");
        }

    }
}
