package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11403 {
    private static int[][] graph;
    private static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //정점 개수
        graph = new int[N][N];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for (int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        //input end
        getTheWay();
        for (var row:graph){
            for (var col:row){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    private static void getTheWay(){
        for (int k=0; k<N; k++){
            // i = 출발 노드
            for (int i=0; i<N; i++){
                // j = 도착 노드
                for (int j=0; j<N; j++){
                    //(i,k) -> (k,j) -> (k,i) 간선 체크
                    if (graph[i][k]==1 && graph[k][j]==1){
                        graph[i][j]=1;
                    }
                }
            }
        }
        //정점(i,j) == 1인 경우 i와 j사이에 간선이 있음을 뜻함
        // i=0 j=1 k=2 (0,2)==1 && (2,1)==1 --> arr[0,1]=1
        // 이해한 대로 (0,0)이 1로 표시되는 이유를 설명해보자면
        // 0에서 1로 간선이 있고, 다시 1에서 2로 간선이, 또다시 2에서 0으로 간선이
        // 있으므로 0에서 0으로 가는 (0,0)도 1로 계산하는 것 같다.

        // (0,0) (0,1) (0,2) 0 1 0 -> (0,1)==1 이므로 0과 1사이 간선
        // (1,0) (1,1) (1,2) 0 0 1 -> (1,2)==1 이므로 1과 2사이 간선
        // (2,0) (2,1) (2,2) 1 0 0 -> (2,0)==1 이므로 2와 0사이 간선
        // 결과
        // 1 1 1
        // 1 1 1
        // 1 1 1

    }
}
