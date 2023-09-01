package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724 {
    private static boolean[] visit;
    private static Integer[][] nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodeList = new Integer[N+1][N+1];
        visit = new boolean[N+1];

        while (M-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodeList[u][v] = nodeList[v][u] = 1;
        }

        int cnt=0;
        int idx = 1;
        while (!checkVisit()){
            if (!visit[idx]){
                dfs(idx);
                cnt++;
            }
            idx++;
        }

        System.out.println(cnt);
    }

    private static void dfs(int start){
        visit[start] = true;
        for (int i=1; i<nodeList.length; i++){
            if (!visit[i] && nodeList[start][i]!=null){
                dfs(i);
            }
        }
    }

    private static boolean checkVisit(){ //방문하지 않은 노드가 있는지 체크
        for (int i=1; i<visit.length; i++){
            if (!visit[i]){
                return false;
            }
        }

        return true;
    }
}
