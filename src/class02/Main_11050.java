package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11050 {
    public static void main(String[] args) throws IOException {

        //이항계수
        // n! / (n-k)!k!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int result = math(N)/(math(N-K)*math(K));
        System.out.println(result);
    }

    public static int math(int num){
        int result = 1;

        for (int i=num; i>=1; i--){
            result *= i;
        }
        return result;
    }
}
