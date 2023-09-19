package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("");
        //input endpoint

        int result = 0;
        int cnt = 0;
        for (int i=1; i<M-1; i++){
            if (s[i-1].equals("I") && s[i].equals("O") && s[i+1].equals("I")){
                cnt++;

                if (cnt==N){
                    cnt--;
                    result++;
                }
                i++;
            }
            else{
                cnt = 0;
            }
        }
        System.out.println(result);
    }
    //OOIOIOIOIIOII
    // 문자열 순회하면서 I나오면 조건 체크
    // -> M만큼 OI가 반복되면 조건 만족함
}