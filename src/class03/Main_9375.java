package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_9375 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        Map<String, Integer> map;
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());
//            if (N==0){
//                sb.append(0).append("\n");
//                continue;
//            }

            map = new HashMap<>();
            for (int i=0; i<N; i++){
                String[] item = br.readLine().split(" ");
                String kind = item[1];

                map.put(kind, map.getOrDefault(kind, 0)+1);
            }

            if (map.size() == 1){
                sb.append(N).append("\n");
            }
            else{
                int result = 1;
                for (var value:map.values()){

                    result *= (value+1);
                }
                sb.append(result-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
