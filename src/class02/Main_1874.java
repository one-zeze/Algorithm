package class02;

import java.io.*;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> newStack = new Stack<>();

        int roop = Integer.parseInt(br.readLine());
        int peekNum = 0;
        while (roop-- > 0){

            int inputNum = Integer.parseInt(br.readLine());
            if (inputNum > peekNum){
                for (int i=peekNum+1; i<=inputNum; i++){
                    newStack.push(i);
                    sb.append("+\n");
                }
                peekNum = newStack.peek();

                newStack.pop();
                sb.append("-\n");
            }
            else if (inputNum < peekNum) {
                if (inputNum == newStack.peek()){
                    newStack.pop();
                    sb.append("-\n");
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }

        }
        var lastStr = sb.lastIndexOf("\n");
        sb.deleteCharAt(lastStr);
        System.out.println(sb);
    }
}
