package class02;

import java.io.*;

public class Main_2292 {
    public static void main(String[] args) throws IOException {

        // 1층 6개의 숫자 2~7
        // 2층 12개의 숫자 8~19
        // 3층 18개의 숫자 20~37
        // n층은 6n개의 숫자를 가짐
        // 중앙에서 입력받은 방까지 거리는 층+1과 같음

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());


        int floor = 1;
        int lastRoom = 1;
        int result = 1;

        while (lastRoom != goal){
            int roop = 6*floor;
//            System.out.print("%d 층:".formatted(floor));

            for (int i=1; i<=roop; i++){
                lastRoom++;
//                System.out.print(lastRoom+"번방 ");
                if (lastRoom == goal){
                    result = floor+1;
                    break;
                }
            }
//            System.out.println();
            floor++;
        }
        System.out.println(result);
    }
}
