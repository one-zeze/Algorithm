package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2630 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String paper = "";

        for (int i=0; i<N; i++){
            paper += br.readLine().replace(" ", "") + "\n";
        }
        System.out.println(paper);
        // 파란색 흰색 둘다 아닌경우
        if (paper.contains("0") && paper.contains("1")){
            // N/2 * N/2로 잘라야됨
            solve();

        }else{ // 처음부터 하나의 색인 경우
            if (paper.contains("0")){
                System.out.println("1\n0");
            }else{
                System.out.println("0\n1");
            }
        }

    }

    public static void solve(){

    }
}
