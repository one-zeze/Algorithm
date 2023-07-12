package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack;

        while (true){
            stack = new Stack<>();
            String str = br.readLine();
            if (str.equals(".")){break;}

            for (var index:str.split("")){
                // 괄호들만 스택에 저장
                if (index.equals("(") || index.equals("[")){
                    stack.push(index);
                    continue;
                }
                // 괄호가 완성되면 스택에서 삭제
                if (index.equals(")") || index.equals("]")){
                    if (!stack.isEmpty()){
                        var last = stack.peek();
                        String VPS = last+index;

                        if (VPS.equals("()") || VPS.equals("[]")){
                            stack.pop();
                        }else{
                            stack.push(index);
                        }
                    }else{
                        stack.push(index);
                    }
                }
            }
            if (stack.size() == 0){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }

        }
    }
}
