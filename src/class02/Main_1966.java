package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());

        for (int i=0; i<roop; i++){
            var NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            var Importance = br.readLine().split(" ");

            //문서 개수가 1개인경우 -> 무조건 첫번째로 인쇄
            if (N == 1){
                System.out.println(1);
            }
            else {
                var result = getSeq(N, M, Importance);
                System.out.println(result);
            }
        }
    }

    private static int getSeq(int num, int seq, String[] importance){
        //중요도 정수형 배열로 저장
        int size = importance.length;
        int[] newList = new int[size];
        for (int i=0; i<size; i++){
            newList[i] = Integer.parseInt(importance[i]);
        }

        //입력받은 순서대로 Queue에 저장
        Queue<Integer> queue = new LinkedList<>();
        for (var item:newList){
            queue.add(item);
        }
        //원하는 문서의 순서:seq, 중요도:newList[seq]
        var targetSeq = seq;
        var targetImp = newList[seq];

        //queue의 최대값이 원하는 문서와 같아질때 까지
        int max = 0;
        int min = 0;
        int cnt = 1;
        int add = 0;
        while (max != targetImp){
            max = Collections.max(queue);
            min = Collections.min(queue);
            if (max == targetImp && min == targetImp){
                return cnt+(queue.size()-add-targetSeq);
            }

            int front = queue.peek();
            //중요도가 높은 순서대로 poll(), cnt++
            if (front == max){
                queue.poll();
                cnt++;
            }
            // 중요도가 가장높은 문서를 출력하기 전까지 que맨뒤로 삽입
            else{
                queue.poll();
                queue.add(front);
                add++;
            }
        }

        return cnt;
    }
}
