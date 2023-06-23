package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var input = br.readLine().split(" ");
        int dayMove = Integer.parseInt(input[0]);
        int slide = Integer.parseInt(input[1]);
        int top = Integer.parseInt(input[2]);

        int day = (top-slide)/(dayMove-slide);
        if ((top-slide)%(dayMove-slide) == 0){
            System.out.println(day);
        }else{
            System.out.println(day+1);
        }

        //높이 V, 낮 A, 밤 B
//        하루이동: A-B
//        Day = v/(A-B)
//
//        도착하면 미끄러지지 않음을 고려하면
//        -> Day = (V-B)/(A-B)
//        나누어 떨어지지 않으면?
//        -> Day = (V-B)/(A-B) +1
//
//        정리하면
//        if( (V-B)%(A-B) == 0){
//        Day = (V-B)/(A-B);
//        }else{
//        Day = (V-B)/(A-B) +1;
//        }
    }
}
