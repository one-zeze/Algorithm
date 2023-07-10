package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (K-- > 0){
            int input = Integer.parseInt(br.readLine());
            if (input != 0){
                stack.push(input);
            } else if (input == 0) {
                stack.pop();
            }
        }

        int sum = 0;
        for (var item:stack){
            sum += item;
        }
        System.out.println(sum);
    }
}
