package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        while (N-->0){
            int input = Integer.parseInt(br.readLine());

            if (input == 0){
                if (maxHeap.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(maxHeap.poll()).append("\n");
                }
            }else{
                maxHeap.add(input);
            }
        }

        System.out.println(sb);
    }
}
