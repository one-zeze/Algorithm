package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10866 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orderNum = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        while (orderNum-- > 0){
            String[] input = br.readLine().split(" ");
            String method = input[0];

            switch (method){
                case "push_front":
                    deque.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(deque.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(deque.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(deque.getFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(deque.getLast());
                    }
                    break;
            }
        }
    }
}
