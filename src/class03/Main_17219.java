package class03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_17219 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        Map<String, String> map = new HashMap<>();
        while (N-- > 0){
            String[] input = br.readLine().split(" ");
            String api = input[0];
            String pwd = input[1];

            map.put(api, pwd);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (M-- > 0){
            String findApi = br.readLine();
            String findPwd = map.get(findApi);

            bw.write(findPwd+"\n");
        }

        bw.flush();
        bw.close();
    }
}
