import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static class Node {
    int cnt;
    long num;

    public Node(int cnt, long num) {
      this.cnt = cnt;
      this.num = num;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    long A = Integer.parseInt(input[0]);
    long B = Integer.parseInt(input[1]);

    Node start = new Node(1, A);
    System.out.println(bfs(start, B));
  }
  
  static int bfs(Node start, long target) {

    Queue<Node> queue = new LinkedList<>();
    queue.add(start);
    
    while (!queue.isEmpty()) {
      Node crt = queue.poll();
      int cnt = crt.cnt;
      long num = crt.num;

      if (num == target) {
        return cnt;
      }

      long next1 = 2 * num;
      if (next1 <= target) {
        queue.add(new Node(cnt + 1, next1));
      }

      long next2 = 10 * num + 1;
      if (next2 <= target) {
        queue.add(new Node(cnt + 1, next2));
      }

    }
    return -1;
  }
}
