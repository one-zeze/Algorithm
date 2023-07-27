package class03;

import java.io.*;
import java.util.ArrayDeque;

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (N-->0){

            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 든 수의 개수
            String input = br.readLine(); // 입력받은 배열

            String result = getResult(p, input).replace(" ", "");
            sb.append(result).append("\n");
            // 숫자만 빼고 제거
            //input = input.replaceAll("[^0-9]", "");
        }
        System.out.println(sb);
    }

    static String getResult(String p, String input){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        String[] str = input.substring(1, input.length()-1).split(",");
        if (!str[0].equals("")){
            for (int i=0; i<str.length; i++){
                int item = Integer.parseInt(str[i]);
                deque.add(item);
            }
        }

        for (int i=0; i<p.length(); i++){
            Character method = p.charAt(i);

            switch (method){
                case 'R':
                    ArrayDeque<Integer> reverse = new ArrayDeque<>();
                    while (!deque.isEmpty()){
                        reverse.add(deque.pollLast());
                    }
                    deque = reverse;
                    break;

                case 'D':
                    if (deque.isEmpty()){
                       return "error";
                    }else{
                        deque.pollFirst();
                    }
                    break;
            }
        }
        sb.append("[");
        for (var item:deque){
            sb.append(item).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
