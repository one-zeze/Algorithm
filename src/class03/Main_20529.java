package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20529 {
    private static String[] mbti_list;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        while (T-->0){
            int N = Integer.parseInt(br.readLine()); //학생 수
            // mbti유형은 16가지, 33부터 최소 하나의 유형은 3개가됨
//            if (N>=33){ -> NumberForamt 에러 발생함, 왜인지 모름;
//                sb.append(0).append("\n");
//                continue;
//            }
            mbti_list = new String[N];

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int i=0; i<N; i++){
                mbti_list[i] = st.nextToken();
            }
            //input end
            sb.append(minDistance(N)).append("\n");
        }
        System.out.println(sb);
    }//main end

    private static int minDistance(int N){
        int distance = Integer.MAX_VALUE;

        for (int i=0; i<N; i++){ //학생 A
            for (int j=i+1; j<N-1; j++){ //학생 B
                for (int z=j+1; z<N; z++){ //학생 C
                    String a = mbti_list[i];
                    String b = mbti_list[j];
                    String c = mbti_list[z];

                    int result = compare(a, b) + compare(a, c) + compare(b, c);
//                    int result = compare(a, b, c);
                    if (result<distance){distance = result;}
                    if (distance==0){break;}
                }
                if (distance==0){break;}
            }
            if (distance==0){break;}
        }
        return distance;
    }

    private static int compare(String a, String b){
        if (a.equals(b)){
            return 0;
        }
        int result = 0;
        for (int i=0; i<4; i++){
            if(a.charAt(i)!=b.charAt(i)){
                result++;
            }
        }
//        for (int i=0; i<4; i++){
//            if (a.charAt(i)!=b.charAt(i)){result++;}
//            if (a.charAt(i)!=c.charAt(i)){result++;}
//            if (b.charAt(i)!=c.charAt(i)){result++;}
//        }
        return result;
    }
}//class
