package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286 {
    private static class myNum implements Comparable<myNum>{
        int val;
        int absVal;
        public myNum(int val, int absVal) {
            this.val = val;
            this.absVal = absVal;
        }

        @Override
        public int compareTo(myNum o) {
            if (this.absVal == o.absVal){
                return this.val-o.val;
            }
            return this.absVal - o.absVal;
        }
    }
    private static PriorityQueue<myNum> absHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-->0){
//            int input = sc.nextInt();
            int input = Integer.parseInt(br.readLine());
            int abs_input = Math.abs(input); //입력값의 절대값
            //0이면 최소값 출력, 배열에서 제거
            //아니면 배열에 추가
            if (input==0){

                if (absHeap.isEmpty()){
//                    System.out.println(0);
                    sb.append(0+"\n");
                }else{
//                    System.out.println(absHeap.poll().val);
                    sb.append(absHeap.poll().val+"\n");
                }

            }
            else{
                absHeap.offer(new myNum(input, abs_input));
            }
        }
        System.out.println(sb);
    }
}
