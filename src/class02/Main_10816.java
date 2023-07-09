package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        var cardList = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (var item:cardList){
            int val = map.getOrDefault(item, 0);
            map.put(item, val+1);
        }

        int M = Integer.parseInt(br.readLine());
        var inputList = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (var item:inputList){
            if (map.containsKey(item)){
                int value = map.get(item);
                sb.append(value).append(" ");
            }
            else{
                sb.append(0).append(" ");
            }

        }

        System.out.println(sb);
    }
}
