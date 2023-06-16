package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준 18111번
public class MineCraft {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int block = Integer.parseInt(input[2]);
        int[][] ground = new int[h][w];

        Map<Integer, Integer> groundHeight = new HashMap<>();

        //2차배열 입력값으로 채우기
        for (int i=0; i<h; i++){
            var newLine = br.readLine().split(" ");

            for (int j=0; j< newLine.length; j++){
                var item = Integer.parseInt(newLine[j]);
                ground[i][j] = item;

                //땅 높이별로 개수 파악
                int hvalue = groundHeight.getOrDefault(item, 0);
                groundHeight.put(item, hvalue+1);
            }
        }
        System.out.println(groundHeight);

        //배열 확인
        for (var height:ground){
            for (var width:height){
                System.out.print(width+" ");
            }
            System.out.println();
        }


        int maxHeight = 0;
        int minHeight = 0;
        for (var height:groundHeight.keySet()){
            if (height > maxHeight){
                maxHeight = height;
            }
        }
        System.out.println("maxH : "+maxHeight);
        int maxGroundNum = groundHeight.get(maxHeight);

        for (var height:groundHeight.keySet()){
            if (height!=maxHeight){
                minHeight = height;
            }
        }
        System.out.println("minH : "+minHeight);
        int minGroundNum = groundHeight.get(minHeight);

        int plusTime = 1*minGroundNum;
        int minusTime = 2*maxGroundNum;

        int fixTime = 0;
        int finalHeight = 0;
        if (maxGroundNum > minGroundNum){
            if (block >= minGroundNum && plusTime != minusTime){
                fixTime = 1*minGroundNum;
                finalHeight = maxHeight;
            }else{
                fixTime = 2*maxGroundNum;
                finalHeight = minHeight;
            }
        }else{
            fixTime = 2*maxGroundNum;
            finalHeight = minHeight;
        }
        System.out.println(fixTime+" "+finalHeight);

    }
}
