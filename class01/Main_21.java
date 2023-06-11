package class01;

import java.io.*;

public class Main_21 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 1;
        for(int i=0; i<3; i++){
            var num = Integer.parseInt(br.readLine());
            sum *= num;
        }

        var numList = Integer.toString(sum).split("");
        for (int j=0; j<10; j++){
            int cnt = 0;

            for (int z=0; z< numList.length; z++){
                var item = Integer.parseInt(numList[z]);

                if (item == j){
                    cnt+=1;
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
    }
}
