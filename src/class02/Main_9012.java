package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<String> stack;
        
        for (int i=0; i<T; i++){
            stack = new Stack<>();
            String[] input = br.readLine().split("");

            String VPS = "";
            for (var item:input){
                VPS = "";
                if (! stack.isEmpty()){
                    var peek = stack.peek();
                    VPS = peek+item;
                }

                if (VPS.equals("()")){
                    stack.pop();
                }
                else{
                    stack.push(item);
                }
            }

            if (stack.isEmpty()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
