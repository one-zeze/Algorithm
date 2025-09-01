import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  
//  static class Node {
//    int row;
//    int value;
//    Node left;
//    Node right;

//    public Node(int value, int row) {
//     this.value = value;
//      this.row = row;
//    }
    
//  }
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int dp[][] = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j <= i; j++) {
        dp[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
 
    for (int i = N - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = dp[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
      }
    }
    
    System.out.println(dp[0][0]);
    // int cnt = 0;
    // Map<Integer, Node> map = new HashMap<>();
    // for (int i = 1; i <= N; i++) {
    //   st = new StringTokenizer(br.readLine());
    //   while (st.hasMoreTokens()) {
    //     cnt++;
    //     int value = Integer.parseInt(st.nextToken());
    //     map.put(cnt, new Node(value, i));
    //   }
    // }

    // int sum = 0;
    // for (int i = 1; i <= cnt; i++) {
    //   Node node = map.get(i);
    //   Node left = map.get(i + node.row);
    //   Node right = map.get(i + node.row + 1);

    //   System.out.println("값: "+node.value+" 왼쪽: "+left.value+" 오른쪽: "+right.value);
    // }

  }
  
}
/* 
경로의 합중에 최대값
5
    7
   3 8
  8 1 0
 2 7 4 4
4 5 2 6 5

30
*/