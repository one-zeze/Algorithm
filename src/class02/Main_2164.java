package class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        // N까지 삽입
        for (int i=1; i<=N; i++){
            queue.add(i);
        }

        while (queue.size() > 1){
            queue.poll();
            int moveToEnd = queue.peek();
            queue.add(moveToEnd);
            queue.poll();
        }

        System.out.println(queue.peek());
    }
}
