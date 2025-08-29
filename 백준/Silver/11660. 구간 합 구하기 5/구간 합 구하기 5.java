import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] table;
  static int[][] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String[] NM = br.readLine().split(" ");
    int N = Integer.parseInt(NM[0]); // N x N
    int M = Integer.parseInt(NM[1]); // result 개수
    table = new int[N+1][N+1];
    dp = new int[N+1][N+1];


    for (int col = 1; col <= N; col++) { // 표, dp 채우기
      st = new StringTokenizer(br.readLine());
      for (int row = 1; row <= N; row++) {
        int value = Integer.parseInt(st.nextToken());
        table[col][row] = value;
        dp[col][row] = dp[col][row - 1] + dp[col - 1][row] - dp[col - 1][row - 1] + value;

      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      // System.out.println(getResult(x1, y1, x2, y2, table));
      int result = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
      System.out.println(result);
    }

  }
  
}
