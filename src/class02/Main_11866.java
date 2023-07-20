package class02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_11866 {
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // (N,K) 요세푸스 순열 출력하기
        //1~N 차례대로 queue에 삽입
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=N; i++){
            queue.add(i);
        }

        //queue 인덱스에 순차적으로 접근하면서, cnt=K이 되면 remove
        sb.append("<");
        while (! queue.isEmpty()) {
            int cnt = 1;

            // 인덱스가 1개면, K번 반복하지 않고 종료
            if (queue.size() == 1){
                sb.append(queue.poll()).append(">");
                break;
            }
            while (cnt < K){
                System.out.println("cnt: %d, que: %s".formatted(cnt, queue));
                int item1 = queue.poll();
                queue.add(item1);
                cnt++;
            }
            sb.append(queue.poll()).append(", ");
        }
        System.out.println(sb);
    }
}

//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i=0; i<N; i++){
//           list.add(i+1);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("<");
//        while (list.size() > 0){
//            if (K > list.size()-1){
//                K = K-list.size();
//                continue;
//            }
//            if (list.size() == 1){
//                sb.append(list.get(K));
//                list.remove(K);
//            }else{
//                sb.append(list.get(K)).append(", ");
//                list.remove(K);
//                K+=2;
//            }
//        }
//        sb.append(">");
//        System.out.println(sb);

//        System.out.println(list);
//        System.out.println(list.get(2));
//        list.remove(2);
//        System.out.println(list.get(4));
//        list.remove(4);
//        System.out.println(list.get(1));