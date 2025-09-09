import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int case_num = Integer.parseInt(br.readLine());

    int[][] sticker;

    for (int i = 0; i < case_num; i++) {
      int N = Integer.parseInt(br.readLine());
      sticker = new int[2][N];

      for (int row = 0; row < 2; row++) {
        st = new StringTokenizer(br.readLine());

        for (int col = 0; col < N; col++) {
          sticker[row][col] = Integer.parseInt(st.nextToken());
        }
      }

      if (N == 1) {
        System.out.println(Math.max(sticker[0][0], sticker[1][0]));
        continue;
      }
      
      int dp[][] = new int[2][N];
      dp[0][0] = sticker[0][0];
      dp[0][1] = sticker[0][1] + sticker[1][0];
      dp[1][0] = sticker[1][0];
      dp[1][1] = sticker[1][1] + sticker[0][0];

      for (int z = 2; z < N; z++) {
        dp[0][z] = sticker[0][z] + Math.max(dp[1][z - 1], dp[1][z - 2]);
        dp[1][z] = sticker[1][z] + Math.max(dp[0][z - 1], dp[0][z - 2]);
      }
      
      int result = Math.max(dp[0][N - 1], dp[1][N - 1]);
      System.out.println(result);
    }

  }
  
}

