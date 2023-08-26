package class03;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1927 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (N-->0){
            int input = sc.nextInt();

            if (input == 0){
                if (minHeap.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(minHeap.poll()).append("\n");
                }
            } else{
                minHeap.add(input);
            }
        }
        System.out.println(sb);

    }
}
