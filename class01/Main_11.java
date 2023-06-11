package class01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var case_size = Integer.parseInt(br.readLine());

        for (int i=0; i<case_size; i++){
            var testCase = br.readLine().split(" ");
            var num1 = Integer.parseInt(testCase[0]);
            var num2 = Integer.parseInt(testCase[1]);

            System.out.println(num1+num2);
        }
    }
}
