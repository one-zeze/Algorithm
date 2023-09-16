package unit_test;

import java.util.Scanner;

public class dfsTest {
    private static boolean[] visit;
    private static int[][] graph;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //노드 개수
        int M = sc.nextInt(); //간선 개수
        int S = sc.nextInt(); //탐색 시작 노드

        visit = new boolean[N+1];
        graph = new int[N+1][N+1];

        while (M-->0){
            int s = sc.nextInt();
            int e = sc.nextInt();

            graph[s][e] = graph[e][s] = 1;
        }

        dfs(S);
    }

    private static void dfs(int start){
        visit[start] = true;
        System.out.print(start+" ");

        for (int i=1; i<graph.length; i++){
            if (!visit[i] && graph[start][i]==1){
                dfs(i);
            }
        }
    }
}
