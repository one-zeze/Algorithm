package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static Integer[][] nodeList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //정점 개수
        int M = Integer.parseInt(input[1]); //간선 개수
        int V = Integer.parseInt(input[2]); //탐색 시작할 정점
        nodeList = new Integer[N+1][N+1]; //노드간의 간선

        while (M-->0){
            String[] node_num = br.readLine().split(" ");
            int value = Integer.parseInt(node_num[0]);
            int linked = Integer.parseInt(node_num[1]);

            nodeList[value][linked] = nodeList[linked][value] = 1; // 양방향 간선
        }
        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        visit = new boolean[N+1]; //노드방문 여부 초기화
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i=1; i<nodeList.length; i++){
            if (!visit[i] && nodeList[start][i] != null){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visit[start] = true;
        sb.append(start).append(" ");

        while (!queue.isEmpty()){
            int n = queue.poll();

            for (int i=1; i< nodeList.length; i++){

                if (nodeList[n][i]!=null && !visit[i]){
                    visit[i] = true;
                    sb.append(i).append(" ");
                    queue.offer(i);
                }
            }
        }
    }
}
