package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 11720번 문제
public class Main_27 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        var nums = br.readLine().split("");
        int sum = 0;

        for (int i=0; i<length; i++){
            sum += Integer.parseInt(nums[i]);
        }

        System.out.println(sum);
    }
}
