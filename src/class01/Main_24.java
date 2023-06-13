package class01;

import java.io.*;

public class Main_24 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //테스트 데이터 개수
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++){
            //테스트 데이터 입력, ex) 호텔의 층수, 방수, 손님순서
            var newLine = br.readLine().split(" ");
            var floor = Integer.parseInt(newLine[0]);
            var room = Integer.parseInt(newLine[1]);
            var guestNum = Integer.parseInt(newLine[2]);

            var result = RoomReservation(floor, room, guestNum);
            bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static String RoomReservation(int floor, int room, int guestNum){

        StringBuilder sb;
        int cnt = 0;

        for (int r=1; r<=room; r++){
            for (int f=1; f<=floor; f++){
                //StringBuilder 초기화
                sb = new StringBuilder();
                //문자열에 층수 추가
                sb.append(f);

                //방번호가 한자리면 0+번호
                if (r<10){
                    sb.append(0);
                    sb.append(r);
                }else{
                    sb.append(r);
                }
                cnt++;

                if (cnt == guestNum){
                    return sb.toString();
                }
            }
        }
        return "방 없음";
    }
}
