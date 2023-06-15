package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Main_25 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var time = br.readLine().split(" ");
        var hour = Integer.parseInt(time[0]);
        var min = Integer.parseInt(time[1]);

        LocalTime target = LocalTime.of(hour, min).minusMinutes(45);
        System.out.println(target.getHour()+" "+ target.getMinute());
    }
}
