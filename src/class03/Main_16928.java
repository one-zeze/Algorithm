package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main_16928 {
    private static Integer[] board = new Integer[101];
    private static boolean[] isLadder = new boolean[101];
    private static boolean[] isSnake = new boolean[101];
    private static Map<Integer, Integer> ladderInfo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        for (int i=1; i<=100; i++){
            board[i] = i;
        }
        for (int i=1; i<=N; i++){ //ladder
            String[] linkInfo = br.readLine().split(" ");
            int start = Integer.parseInt(linkInfo[0]);
            int end = Integer.parseInt(linkInfo[1]);
//            isLadder[start] = true;
            isLadder[start] = true;
            ladderInfo.put(start, end);
        }
        for (int i=1; i<=M; i++){
            String[] linkInfo = br.readLine().split(" ");
            int start = Integer.parseInt(linkInfo[0]);
            isSnake[start] = true;
        }
        //input end
        //ex) 사다리가 2-60, 21-99 일때 21로 가는게 더 빠름
//        System.out.println(bfs());
        bfs();
        System.out.println(board[100]);

    }//main method

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()){
            int crt = queue.poll();
            int min = 0; //not snake
            for (int i=1; i<=6; i++){
                if (!isSnake[crt+i]){
                    min = crt+i;
                }

                if (isLadder[crt+i]){
                    int end = ladderInfo.get(crt+i);
                    board[end] = board[crt]+1;
                }
                board[crt+i] = board[crt]+1;
            }
            queue.offer(min);
        }
    }
//    private static int bfs(){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);
//
//        int cnt = 0;
//        while (!queue.isEmpty()){
//            int crt = queue.poll();
//            if (crt>=94){
//                cnt++;
//                break;
//            }
//            int max = 0;
//            int min = 0;
//            for (int i=1; i<=6; i++){
//                if (isLadder[crt+i] && ladderInfo.get(crt+i)>max){
//                    max = ladderInfo.get(crt+i);
//                    continue;
//                }
//                if (!isSnake[crt+i]){ //snake 제외한 가장 큰값
//                    min = crt+i;
//                }
//            }
//
//            if (max==0){
//                queue.offer(min);
//            }else{
//                queue.offer(max);
//            }
//            cnt++;
//        }
//
//        return cnt;
//    }
}//Main class
