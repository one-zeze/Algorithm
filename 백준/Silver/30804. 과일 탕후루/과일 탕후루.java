import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0; // 윈도우의 왼쪽 끝
        int maxLength = 0; // 최대 탕후루 길이
        int[] kindCount = new int[10]; 
        int distinctKinds = 0;

        for (int right = 0; right < N; right++) {
            int currentFruit = fruits[right];
            if (kindCount[currentFruit] == 0) {
                distinctKinds++;
            }
            kindCount[currentFruit]++;
            while (distinctKinds > 2) {
                int leftFruit = fruits[left];
                kindCount[leftFruit]--;
                if (kindCount[leftFruit] == 0) {
                   
                    distinctKinds--;
                }
                left++; 
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
