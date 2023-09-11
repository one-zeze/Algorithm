package class03;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1697 {
    private static Integer[] subin = new Integer[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if (N>=K){
            System.out.println(N-K);
        }else{
            bfs(N, K);
            System.out.println(subin[K]);
        }
    }

    private static void bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        subin[start] = 0;

        while (!queue.isEmpty()){
            if (subin[end] != null){
                return;
            }
            int crt = queue.poll();
            int cnt = subin[crt];

            if (crt+1<=100000 && subin[crt+1]==null){
                subin[crt+1]= cnt+1;
                queue.offer(crt+1);
            }
            if (crt-1>=0 && subin[crt-1]==null){
                subin[crt-1]= cnt+1;
                queue.offer(crt-1);
            }
            if (crt*2<=100000 && subin[crt*2]==null){
                subin[crt*2]= cnt+1;
                queue.offer(crt*2);
            }
        }
    }
}
