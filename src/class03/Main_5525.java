package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();
        if (N>100 || M>10000){return;}
        //input endpoint

        int result = solve(str, N);
        System.out.println(result);
    }
    //OOIOIOIOIIOII
    // 문자열 순회하면서 I나오면 조건 체크
    // -> M만큼 OI가 반복되면 조건 만족함
    private static int solve(String str, int N){
        int cnt = 0;
        int start_idx = 0;
        Set<String> IOSet;

        for (int i=start_idx; i<str.length()-(2*N); i++){

            if (str.charAt(i)=='I'){
                IOSet = new HashSet<>();

                for (int j=1; j<=2*N; j+=2){
                    String isO = Character.toString(str.charAt(i+j));
                    String isI = Character.toString(str.charAt(i+j+1));
                    String plus = isO+isI;
                    IOSet.add(plus);
                }
                if (IOSet.size()==1 && IOSet.contains("OI")){cnt++;}
            }

        }

        return cnt;
    }
}