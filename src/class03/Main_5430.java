package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_5430 {
    public static void main(String[] args) throws IOException {
        long bTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        while (N-->0){

            String p = br.readLine(); // 수행할 함수
            int n = Integer.parseInt(br.readLine()); // 배열에 든 수의 개수
            var input = br.readLine(); // 입력받은 배열

            // 숫자만 빼고 제거
            String remove = "[^0-9]";
            input = input.replaceAll(remove, "");

            sb.append(getResult(n, p, input)).append("\n");
        }
        System.out.print(sb);
        long aTime = System.currentTimeMillis();
        long diffTime = (aTime-bTime)/1000;
        System.out.println(diffTime);
    }

    static String getResult(int n, String p, String input){
        StringBuilder sb = new StringBuilder();
        String result = "";
        ArrayList<Integer> parseList = new ArrayList<>();
        for (int idx=0; idx<n; idx++){
            int target = Character.getNumericValue(input.charAt(idx));
            parseList.add(target);
        }

        for (int i=0; i<p.length(); i++){
            var method = p.charAt(i);

            switch (method){
                case 'R':
                    ArrayList<Integer> reverse = new ArrayList<>();
                    for (int j= parseList.size()-1; j>=0; j--){
                        reverse.add(parseList.get(j));
                    }
                    parseList = reverse;
                    break;
                case 'D':
                    if (parseList.isEmpty()){
                        return "error";
                    }else{
                        parseList.remove(0);
                    }
                    break;
            }
        }
        sb.append("[");
        for (var item:parseList){
            sb.append(item).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        result = sb.toString();
        return result;
    }
}
