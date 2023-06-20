package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_15829 {
    public static void main(String[] args) throws IOException {

        int r = 31;
        int M = 1234567891;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        var input = br.readLine().split("");

        getH(input, len, r, M);
    }

    public static void getH(String[] input,int len, int r, int M){
        int H = 0;
        int inputSum = 0;

        Map<Character, Integer> map = new HashMap<>();
        int cnt = 1;
        for (char i='a'; i<='z'; i++){
            map.put(i, cnt);
            cnt++;
        }

        System.out.println(map.entrySet());
        var key = map.keySet();
        for (var item:key){
            var value = map.get(item);
            System.out.println(item+", "+value);
            inputSum += value * (int) Math.pow(r, value);
            System.out.print(inputSum+" ");
        }
        H = inputSum/M;
        System.out.println(inputSum+","+(inputSum/M));

//        for (int i=0; i<(len-1); i++){
//            var value = map.getOrDefault(input[i], 0);
//            int num = (int) Math.pow(r, value);
//            inputSum += value*num;
//        }
//
//        H = inputSum/M;
//        System.out.println(H);
    }
}
