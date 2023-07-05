package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929 {
    public static void main(String[] args) throws IOException {

        //1.M이상 N이하 소수 모두출력
        //2.입력값중 소수가 없는경우는 없음
        //3.오름차순으로 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        var input = br.readLine().split(" ");
        int min = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[1]);

        //에라스토스의 체
        int[] result = new int[max+1];
        for (int i=0; i<result.length; i++){
            result[i] = i;
        }
        // 0,1은 소수가 아님
        result[0] = 0;
        result[1] = 0;

        for (int i=2; i<max; i++){

            if (result[i] != 0){
                for (int j=i*i; j<=max; j+=i){
                    result[j] = 0;
                }
            }
        }
        
        for (var item:result){
            if (item != 0 && item>=min){
                sb.append(item).append("\n");
            }
        }
        System.out.print(sb);
    }
}
