package class01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var firstLine = br.readLine().split(" ");
        var len = Integer.parseInt(firstLine[0]);
        var max = Integer.parseInt(firstLine[1]);

        int[] arr = new int[len];
        var secondLine = br.readLine().split(" ");
        for (int i=0; i<len; i++){
            var num = Integer.parseInt(secondLine[i]);
            if (num < max){
                System.out.println(num);
            }
//            arr[i] = Integer.parseInt(secondLine[i]);
        }

//        Scanner scan = new Scanner(System.in);
//
//        var len = scan.nextInt();
//        var max = scan.nextInt();
//        int[] resultList = new int[len];
//        System.out.println("len: %d, max: %d".formatted(len, max));
//
//        for (int i=0; i<len; i++){
//            resultList[i] = scan.nextInt();
//
//            if (resultList[i] < max){
//                System.out.println(resultList[i]);
//            }
//        }

    }
}
