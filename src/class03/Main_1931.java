package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        /*
        time[][0] 회의시작
        time[][1] 회의종료
        */
        int[][] time = new int[N][2];

        StringTokenizer st;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){
                    //종료시간이 같으면 시작이 빠른순으로 정렬
                    return o1[0]-o2[0];
                }

                return o1[1]-o2[1];
            }
        });

        int cnt=0;
        int prev_end = 0;
        for (int i=0; i<N; i++){
            //이전 회의 종료시간 <= 회의 시작시간 이면, 이전회의 갱신
            if (prev_end <= time[i][0]){
                prev_end = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

        //i번째, i+1번째 회의 끝나는 시간 이후로 가능한 회의 개수 카운트
        //cnt(i) < cnt(i+1) 라면? -> i번째 회의 확정
        //cnt(i) > cnt(i+1) 라면? -> i+1번째 회의 확정
        //cnt(i) == cnt(i+1) 라면? -> continue
        //i+2번째, i+3번째 비교 .......N-2번째, N-1번째 비교

        //cnt()
        //i번째 끝나는 시간과 i+1번째 시작하는 시간 비교
        //안겹치면 continue
        //겹치면? ->

    }
}
