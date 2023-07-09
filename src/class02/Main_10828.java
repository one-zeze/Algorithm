package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderNum = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        while(orderNum-- > 0){
            var input = br.readLine().split(" ");
            String method = input[0];

            if (method.equals("push")){
                stack.push(Integer.parseInt(input[1]));
            }
            else if (method.equals("pop")) {
                if (stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if (method.equals("size")) {
                System.out.println(stack.size());
            }
            else if (method.equals("empty")){
                if (stack.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if (method.equals("top")){
                if (stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
