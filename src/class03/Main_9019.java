package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9019 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visit = new boolean[10000];
            String[] command = new String[10000];

            queue.offer(a);
            visit[a] = true;
            Arrays.fill(command, "");

            while (!queue.isEmpty()){
                int crt = queue.poll();

                int D = (2*crt)%10000;
                int S = crt==0 ? 9999:crt-1;
                int L = (crt%1000) * 10 + crt/1000;
                int R = (crt%10) * 1000 + crt/10;

                if (!visit[D]){
                    queue.offer(D);
                    visit[D] = true;
                    command[D] = command[crt] + "D";
                }
                if (!visit[S]){
                    queue.offer(S);
                    visit[S] = true;
                    command[S] = command[crt] + "S";
                }
                if (!visit[L]){
                    queue.offer(L);
                    visit[L] = true;
                    command[L] = command[crt] + "L";
                }
                if (!visit[R]){
                    queue.offer(R);
                    visit[R] = true;
                    command[R] = command[crt] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }//main
}//Class
