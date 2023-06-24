package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_18111 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int block = Integer.parseInt(input[2]);

        int[][] ground = new int[row][col];
        //2차배열 입력값으로 채우기
        for (int i=0; i<row; i++){
            var newCol = br.readLine().split(" ");

            for (int j=0; j<col; j++){
                ground[i][j] = Integer.parseInt(newCol[j]);
            }
        }
        //배열 확인
        printGround(ground);
        var result = delBlock(ground, row, col, block);
        System.out.println(result[0]+" "+result[1]);
    }


    public static void printGround(int[][] ground){
        for (var index:ground){
            for (var item:index){
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }

    public static int[] delBlock(int[][] ground, int row, int col, int block){
        //블록 높이별 개수 파악
        Map<Integer, Integer> resultMap = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] resultList = new int[2];
        for (var index:ground) {
            for (var item : index) {
                int value = map.getOrDefault(item, 0);
                map.put(item, value + 1);
            }
        }
//        System.out.println(map.entrySet());

        //블록을 쌓는경우에, 가진 블록이 필요한 블록보다 작은지 체크해야함
        //-> 가장 높은높이를 만드는데에 필요한 블록 개수 구해야함
        var heightSet = map.keySet();
        
        //가장 높은 높이 구하기
        int maxHeight = 0;
        for (var maxKey:heightSet){
            if (maxKey > maxHeight){
                maxHeight = maxKey;
            }
        }
        //필요한 블록 카운트
        int needBlock = 0;
        for (var z:ground){
            for (var x:z){
                if (x != maxHeight){
                    needBlock += (maxHeight-x);
                }
            }
        }
        
        //각 높이를 기준으로 블럭을 제거해보기
        for (var key:heightSet){
            //기준높이 바뀔때, 걸린시간 초기화
            int time = 0;
            
            //배열순환
            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){

                    //기준인 높이보다 작으면 -> 블록쌓기
                    if (ground[i][j]<key && needBlock > block){
                        time += (key-ground[i][j]);
                    }
                    else {
                        time += (ground[i][j]-key)*2;
                    }
                    //기준인 높이보다 크면 -> 블록제거
//                    else if (ground[i][j]>key) {
//                        time += (ground[i][j]-key)*2;
//                    }
                }
            }
//            System.out.println(key+", "+time);
            resultMap.put(key, Math.abs(time));
            if (key>resultList[0] && Math.abs(time) <resultList[1]){
                resultList[0] = key;
                resultList[1] = Math.abs(time);
            }
            System.out.println(resultList[0]+" "+resultList[1]);
        }

//        System.out.println(resultMap.entrySet());
        return resultList;
    }

}
