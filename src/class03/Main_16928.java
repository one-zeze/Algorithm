package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16928{
    static int[] board = new int[101];
    static boolean[] visit = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        //보드 채우기
        for (int i=1; i<101; i++){
            board[i] = i;
        }
        // 사다리, 뱀
        for (int i=1; i<=N+M; i++){
            String[] teleporting = br.readLine().split(" ");
            int from = Integer.parseInt(teleporting[0]);
            int to = Integer.parseInt(teleporting[1]);

            board[from] = to;
        }

        int result = bfs(1);
        System.out.println(result);
    }//main method
    private static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.offer(start);
        Integer[] cnt = new Integer[101]; //인덱스별로 몇번째 방문인지 기록
        cnt[start] = 0;

        while (cnt[100]==null){
            int crt = queue.poll();

            for (int i=1; i<=6; i++){
                int next_idx = crt+i; //다음 인덱스
                if (next_idx>100){
                    continue;
                }

                if (cnt[next_idx] == null){
                    queue.offer(board[next_idx]);
                    cnt[next_idx] = cnt[board[next_idx]] = cnt[crt]+1;
                }
            }
        }

        return cnt[100];
    }

}//main class