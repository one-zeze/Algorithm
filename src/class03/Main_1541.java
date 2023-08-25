package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1541번, 잃어버린 괄호
public class Main_1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "-", false);
        Deque<Integer> deque = new LinkedList<>();
        while (st.hasMoreTokens()){
            String token = st.nextToken();

            if (token.contains("+")){
                String[] nums = token.split("\\+");
                int sum = 0;
                for (var num:nums){
                    sum += Integer.parseInt(num);
                }
                deque.add(sum);
            }else{
                deque.add(Integer.parseInt(token));
            }
        }

        while (deque.size()>1){
            int num1 = deque.poll();
            int num2 = deque.poll();

            deque.addFirst(num1-num2);
        }
        System.out.println(deque.peek());
    }
}
