import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    long num = Integer.parseInt(input[0]);
    long loop = Integer.parseInt(input[1]);
    long devide = Integer.parseInt(input[2]);

    
    long result = devide_conquer(num, loop, devide);
    System.out.println(result);
  }

  static long devide_conquer(long num, long loop, long devide) {
    if (loop == 1) {
      return num % devide;
    }
    
    long temp = devide_conquer(num, loop / 2, devide);

    if (loop % 2 == 0) {
      return (temp * temp) % devide;
    }
    else {
      return (((temp * temp) % devide) * (num % devide)) % devide;
    }
  }
  
}