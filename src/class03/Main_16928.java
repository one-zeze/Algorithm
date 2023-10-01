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
    private static boolean[] visit = new boolean[101];
    private static Map<Integer, Integer> ladder = new HashMap<>();
    private static Map<Integer, Integer> snake = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        for (int i=1; i<=100; i++){
            board[i] = i;
        }
        for (int i=1; i<=N; i++){
            String[] linkInfo = br.readLine().split(" ");
            int start = Integer.parseInt(linkInfo[0]);
            int end = Integer.parseInt(linkInfo[1]);
            ladder.put(start, end);
        }
        for (int i=1; i<=M; i++){
            String[] linkInfo = br.readLine().split(" ");
            int start = Integer.parseInt(linkInfo[0]);
            int end = Integer.parseInt(linkInfo[1]);
            snake.put(start, end);
        }
        //input end
        //ex) 사다리가 2-60, 21-99 일때 21로 가는게 더 빠름
        int cnt = 0;
        for (int i=1; i<100; i++){

            for (int j=1; j<=6; j++){
                if (i+j >= 100){
                    cnt++;
                    i=100;
                    break;
                }
//                visit[i+j] = true;
                if (ladder.get(i+j)!=null){
                    i = ladder.get(i+j);
                    cnt++;
                    break;
                }
            }
            if (i>=100){break;}
            for (int z=6; z>0; z--){
                if (snake.get(i+z)==null){
                    i+=z;
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }//main method

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visit[1] = true;

        while (!queue.isEmpty()){
            int crt = queue.poll();

        }
    }
}//Main class
