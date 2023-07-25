package class03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main_1620 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        String[] numList = new String[N];
        int pocketNum = 1;
        while (N-- > 0){
            var pocketmon = br.readLine();
            map.put(pocketmon, pocketNum);
            numList[pocketNum-1] = pocketmon;
            pocketNum++;
        }

        for (int i=0; i<M; i++){
            var pocketmon = br.readLine();

            if (map.containsKey(pocketmon)) {
                bw.write(map.get(pocketmon)+"\n");
            }else{
                int val = Integer.parseInt(pocketmon)-1;
                bw.write(numList[val]+"\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
