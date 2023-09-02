package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18870 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> coor = new ArrayList<>();
        List<Integer> sortedCoor = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++){
            int token = Integer.parseInt(st.nextToken());
            coor.add(token);
            sortedCoor.add(token);
        }
        Collections.sort(sortedCoor);

        Map<Integer, Integer> coorMap = new HashMap<>();
        int cnt = 0;
        for (int idx:sortedCoor){
            if (coorMap.get(idx) == null){
                coorMap.put(idx, cnt);
                cnt++;
            }
        }

        for (int c:coor){
            sb.append(coorMap.get(c)+" ");
        }

        //결과 출력
        System.out.println(sb);
    }
}
