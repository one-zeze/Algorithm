package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        //중복 제거를 위해 Set에 입력값 저장
        for (int i=0; i<N; i++){
            set.add(br.readLine());
        }
        //String 배열로 변환
        String[] wordList = set.toArray(new String[0]);

        //정렬
       Arrays.sort(wordList, (w1,w2)->{
           if (w1.length() == w2.length()){
               int index = 0;
               while (w1.charAt(index) == w2.charAt(index)){
                   index++;
               }
               return Integer.compare(w1.charAt(index), w2.charAt(index));
           }
           else{
               return Integer.compare(w1.length(), w2.length());
           }
       });

        for (var item:wordList){
            System.out.println(item);
        }
    }
}
