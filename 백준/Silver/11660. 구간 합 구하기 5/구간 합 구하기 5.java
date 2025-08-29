import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]); // N x N
    int M = Integer.parseInt(NM[1]); // result 개수
    int[][] dp = new int[N+1][N+1];


    for (int row = 1; row <= N; row++) { // 표, dp 채우기
      st = new StringTokenizer(br.readLine());
      for (int col = 1; col <= N; col++) {
        int value = Integer.parseInt(st.nextToken());
        dp[row][col] = dp[row][col - 1] + dp[row - 1][col] - dp[row - 1][col - 1] + value;

      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int result = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
      sb.append(result).append("\n");
    }

    System.out.print(sb.toString());
  }
  
}
