package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667 {
    static class Coor{
        int x;
        int y;
        Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static Integer[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new Integer[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for (int i=1; i<=N; i++){
            String[] input = br.readLine().split("");
            for (int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        //input endpoint

        List<Integer> result = new ArrayList<>();
        int complex=0;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (!visit[i][j] && map[i][j]==1){
                    result.add(bfs(new Coor(i, j)));
                    complex++;
                }
            }
        }
        Collections.sort(result);
        System.out.println(complex); // complex == result.size()
        result.forEach(System.out::println);
    }

    private static int bfs(Coor start){
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(start);
        visit[start.x][start.y] = true;

        int cnt=1;
        int[] moveX = {1,-1,0,0};
        int[] moveY = {0,0,1,-1};
        while (!queue.isEmpty()){
            Coor crt = queue.poll();

            for (int i=0; i<4; i++){
                int newX = moveX[i]+crt.x;
                int newY = moveY[i]+crt.y;
                if (newX>0 && newX<map.length && newY>0 && newY<map.length){
                    if (map[newX][newY]==1 && !visit[newX][newY]){
                        queue.offer(new Coor(newX, newY));
                        visit[newX][newY] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
