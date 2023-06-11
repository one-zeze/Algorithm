package class01;

import java.io.*;

public class Main_17 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = Integer.parseInt(br.readLine());

        for(int i=0; i<max; i++){

            var testCase = br.readLine();
//            System.out.println("count:"+i+","+testCase);
//            bw.write(testCase+"\n");
            bw.write(solution(testCase)+"\n");

        }
        bw.flush();
        bw.close();
    }

    public static int solution(String param){
        int score = 0;
        int sum = 0;

        for (int i=0; i<param.length(); i++){
            String item = String.valueOf(param.charAt(i));

            if (item.equals("O")){
                score += 1;
                sum += score;
            }else {
                score = 0;
            }
        }
//        System.out.println(sum);
        return sum;
    }
}
