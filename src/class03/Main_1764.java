package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        //듣도 못한
        Map<String, Boolean> map = new HashMap<>();
        for (int i=0; i<N; i++){
            map.put(br.readLine(), false);
        }

        //보도 못한
        ArrayList<String> result = new ArrayList<>();
        for (int j=0; j<M; j++){
            String name = br.readLine();
            //듣보
            if (map.containsKey(name)){
                result.add(name);
            }
        }
        //사전순 정렬
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (var item:result){
            sb.append(item).append("\n");
        }

        System.out.println(sb);
    }
}
