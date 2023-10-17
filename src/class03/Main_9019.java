package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_9019 {
    private static class Register{
        int n;
        String command_stack;

        public Register(int n, String command_stack) {
            this.n = n;
            this.command_stack = command_stack;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-->0){
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            if (B==0){
                for (int i=0; i<(A-B); i++){
                    sb.append("S");
                }
            }
            else{
                sb.append(bfs(A, B)).append("\n");
            }
        }
        System.out.println(sb);
    }//main
    private static String bfs(int start, int target){
        String[] command = {"D", "S", "R", "L"};

        boolean[] visit = new boolean[10000];
        Queue<Register> queue = new LinkedList<>();
        queue.offer(new Register(start, ""));
        visit[start] = true;

        while (!queue.isEmpty()){
            Register crt = queue.poll();
            if (crt.n == target){
                return crt.command_stack;
            }
            for (int i=0; i<4; i++){
                Register next = DSLR(command[i], crt);
                if (!visit[next.n]){
                    visit[next.n] = true;
                    queue.offer(next);
                }
            }
        }

        return "";
    }
    private static Register DSLR(String cmd, Register crt){
        int newN = 0;

        if (cmd.equals("D")){
            newN = 2*crt.n;
            if (newN>9999){
                newN %= 10000;
            }
        }
        if (cmd.equals("S")){
            newN = crt.n-1;
            if (newN<=0){
                newN = 9999;
            }
        }
        if (cmd.equals("L")){
            int temp = crt.n % 1000;
            newN = (temp * 10) + (crt.n / 1000);
        }
        if (cmd.equals("R")){
            int temp = crt.n % 10;
            newN = (temp * 1000) + (crt.n / 10);
        }

        return new Register(newN, crt.command_stack+cmd);
    }
}//Class
