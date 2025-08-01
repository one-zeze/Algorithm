import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); //참가자 수
    String[] subscriber = br.readLine().split(" ");//사이즈별 개수
    String[] amount = br.readLine().split(" ");// 묶음 개수

    int T = Integer.parseInt(amount[0]); // 티 묶음
    int P = Integer.parseInt(amount[1]); // 펜 묶음


    calc_T(subscriber, T);
    calc_P(N, P);
  }
  
  static void calc_T(String[] size_arr, int unit) {
    // 그냥 반올림 계산 ㅎ ㅐ버리면 값 똑같다
    // 또는 unit-1 값을 더해주면 정수 계산이 나누어 떨어지게 할 수 있다.
    int cnt = 0;
    for (int i = 0; i < size_arr.length; i++) {
      int index = Integer.parseInt(size_arr[i]); // cnt of crt T - size
      cnt += (index + unit - 1) / unit;
    }
      System.out.println(cnt);
  }

    

  static void calc_P(int people, int unit) {
    int cnt = people / unit;
    int rest = people % unit;
    System.out.printf("%d %d", cnt, rest);
  }

}
