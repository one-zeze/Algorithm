import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] cost;
  static int[][] dp;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int cnt = Integer.parseInt(br.readLine());
    cost = new int[cnt][3];
    dp = new int[cnt][3];

    StringTokenizer st;
    for (int i = 0; i < cnt; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 3; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 입력 끝

    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];

    int result = Math.min(
    getCost(cnt - 1, 0),
    Math.min(getCost(cnt - 1, 1), getCost(cnt - 1, 2))
    );
    
    System.out.println(result);
  }
  
  // n = row, color = col
  static int getCost(int n, int color) {
    
    if (dp[n][color] == 0) {
        
      if (color == 0) {
        dp[n][0] = Math.min(getCost(n - 1, 1), getCost(n - 1, 2)) + cost[n][0];
      }
      else if (color == 1) {
        dp[n][1] = Math.min(getCost(n - 1, 0), getCost(n - 1, 2)) + cost[n][1];
      }
      else if (color == 2) {
        dp[n][2] = Math.min(getCost(n - 1, 0), getCost(n - 1, 1)) + cost[n][2];
      }
    }

    return dp[n][color];
  }
}