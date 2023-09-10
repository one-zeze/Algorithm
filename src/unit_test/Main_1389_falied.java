package unit_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main_1389_falied {
    private static int[][] users;
    private static boolean[] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        users = new int[N+1][N+1];

        while (M-->0){
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int f = Integer.parseInt(input[1]);

            users[u][f] = users[f][u] = 1;
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i=1; i<=N; i++){
            int result = kevin_bacon(i);
            resultMap.put(i, result);
        }

        int min = Integer.MAX_VALUE; //케빈 베이컨 수
        int result = 0; //사람번호
        for (int r:resultMap.keySet()){
            int val = resultMap.get(r);

            if (val < min){ //케빈 베이컨 수가 가장 작은사람 갱신
                min = val;
                result = r;
                continue;
            }
            if (val == min){ //케빈 베이컨 수가 같은경우 key값 비교후 갱신
                if (r<result){
                    result = r;
                }
            }
        }
        System.out.println(result);
    }

    private static int kevin_bacon(int start){
        int cnt=0;
        for (int i=1; i<=N; i++){
            visit = new boolean[N+1];
            if (start!=i){
                cnt += bfs(start, i);
            }
        }
        return cnt;
    }

    private static int bfs(int start, int end){
        int cnt=0;
        Queue<Integer> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int node = queue.poll();

            if (node == end){
                return cnt;
            }
            for (int i=1; i<=N; i++){
                if (!visit[i] && users[node][i]==1){ //방문하지 않았고, 연결된 노드
                    visit[i] = true;
                    queue.offer(i);
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }
}
