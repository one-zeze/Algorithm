package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11659 {
    static int[] dp = new int[1000];
    static String[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        
        int M = Integer.parseInt(NM[1]); //합을 구하는 횟수
        nums = br.readLine().split(" ");
        dp[0] = Integer.parseInt(nums[0]);

        int sum_stack = 0;
        for (int i=0; i< nums.length-1; i++){
            sum_stack += Integer.parseInt(nums[i]);
            dp[i] = sum_stack;
        }

        StringBuilder sb = new StringBuilder();
        while (M-->0){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            int sum = solve(x,y);

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    public static int solve(int x, int y){
        if (x==1){
            return dp[y];
        }
        else{
            int front = 0;
            for (int i=0; i<x;){
                front += Integer.parseInt(nums[i]);
            }

            return dp[y]-front;
        }
    }
}
