package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_11725 {
    static int N;
//    static int[][] graph;
    static ArrayList<Integer> list[];
    static int[] parentNode;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        graph = new int[N+1][N+1];
        parentNode = new int[N+1];
        visit = new boolean[N+1];
        list = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

//            graph[a][b] = graph[b][a] = 1;
            list[a].add(b);
            list[b].add(a);
        }

        findParent(1);

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=N; i++){
            sb.append(parentNode[i]+"\n");
        }

        System.out.print(sb);
    }//main

    static void findParent(int node){
        visit[node] = true;

        for (int idx:list[node]){
            if (!visit[idx]){
                parentNode[idx] = node;
                findParent(idx);
            }
        }
    }
}
