import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int destroyed_idx = input.lastIndexOf('*'); // 홀수: x3, 짝수: x1

    // System.out.printf("입력: %s, 손상 인덱스: %d \n", input, destroyed_idx);

    int sum = 0;
    for (int i = 0; i < input.length(); i++) {
      if (i != destroyed_idx) {

        int tmp = Character.getNumericValue(input.charAt(i));

        if (i == 0 || i % 2 == 0) {
          sum += tmp;
        } else if (i == 1 || i % 2 == 1) {
          sum += tmp * 3;
        }

      }
    }

    // System.out.println("Sum : " + sum);

    restore(destroyed_idx, sum);
  }
  
  static int restore(int idx, int sum) {
    int total = 0;
    for (int num = 0; num < 10; num++) {

      if (idx == 0 || idx % 2 == 0) {
        total = sum + num;
      } else if (idx == 1 || idx % 2 == 1) {
        total = sum + (3*num);
      }

      if (total % 10 == 0) {
        System.out.println(num);
        break;
      }
    }
    return 0;
  }
}
