package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1978 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());
        var numList = br.readLine().split(" ");

        int cnt = 0;
        for (var i:numList){
            int item = Integer.parseInt(i);

            if (item>1 && solution(item)){
                cnt++;
            } else if (item == 2) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean solution(int num){
        boolean flag = false;

        for (int i=2; i<num; i++){
            if (num%i == 0){
                return false;
            }else {
                flag = true;
            }
        }

        return flag;
    }
}
