package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_22 {
    public static  void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var newLine = br.readLine().split(" ");
        int cnt = 0;

        for (var word:newLine){
//            System.out.println(word);
            if (word.isBlank()){

            }else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
