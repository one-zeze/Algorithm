import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  

  static class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 노드 개수

    Map<String, Node> tree = new HashMap<>();
    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");

      String value = input[0];
      String l_value = input[1];
      String r_value = input[2];
      Node p = tree.getOrDefault(value, new Node(value));

      if (l_value != ".") {
        Node left = new Node(l_value);
        p.left = left;
        tree.put(l_value, left);
      }
      if (r_value != ".") {
        Node right = new Node(r_value);
        p.right = right;
        tree.put(r_value, right);
      }

      tree.put(value, p);
    }

    Node root = tree.get("A");
    preorder(root);
    System.out.println();
    inorder(root);
    System.out.println();
    postorder(root);


  }

  // 전위
  static void preorder(Node node) {
    if (!node.value.equals(".")) {
      System.out.print(node.value);
      preorder(node.left);
      preorder(node.right);  
    }
  }
  // 중위
  static void inorder(Node node) {
    if (!node.value.equals(".")) {
      inorder(node.left);
      System.out.print(node.value);
      inorder(node.right);
    }
   
  }
  // 후위
  static void postorder(Node node) {
    if (!node.value.equals(".")) {
      postorder(node.left);
      postorder(node.right);
      System.out.print(node.value);
    }
  }
}