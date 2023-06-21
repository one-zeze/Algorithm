package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_15829 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var len = Integer.parseInt(br.readLine());
        var input = br.readLine();
        int M = 1234567891;
        int s = 31;

        //a~z 번호부여
        Map<Character, Integer> map = new HashMap<>();
        int cnt=1;
        for (char i='a'; i<='z'; i++){
            map.put(i, cnt);
            cnt++;
        }
        System.out.println(map.entrySet());

        int sum=0;
        for (int i=0; i<len; i++){

            int value = map.get(input.charAt(i));
            System.out.print(value+" x ");

            int r = 1;
            for (int j=0; j<i; j++){
                s %= M;
                r *= s;

            }
            System.out.println(r);
            sum += (value % M) * (r % M);
        }
        sum %= M;
        System.out.println(sum);
    }
}
