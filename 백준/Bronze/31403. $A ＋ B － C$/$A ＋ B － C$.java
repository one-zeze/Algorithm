import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    int B = Integer.parseInt(br.readLine());
    int C = Integer.parseInt(br.readLine());
    
    System.out.println(A + B - C);

    String plus = String.valueOf(A) + String.valueOf(B);
    // System.out.println(plus);
    int minus = Integer.parseInt(plus) - C;
    System.out.println(minus);

  }
}
