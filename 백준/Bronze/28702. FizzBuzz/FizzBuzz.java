import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int num = 0;
    // input
    for (int i = 0; i < 3; i++) {

      String str = br.readLine();
      Character c = str.charAt(0);

      if (c != 'F' && c != 'B') {
        num = Integer.parseInt(str);
      }

      if (num != 0) {
        num++;
      }

    }

    // print
    if (num%3 == 0 && num%5 == 0) {
      System.out.println("FizzBuzz");
    }
    else if (num % 3 == 0) {
      System.out.println("Fizz");
    }
    else if (num % 5 == 0) {
      System.out.println("Buzz");
    }
    else {
      System.out.println(num);
    }
    
  }
}
