package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //Coor class 배열
        Coor[] coorList = new Coor[N];

        for (int i=0; i<N; i++){
            var input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            coorList[i] = new Coor(x,y);
        }

        //좌표객체 정렬
        Arrays.sort(coorList, (o1, o2)-> {
            if (o1.x == o2.x){
                return Integer.compare(o1.y, o2.y);
            }else{
                return Integer.compare(o1.x, o2.x);
            }
        });

        //출력
        for (var item:coorList){
            System.out.println(item.x+" "+item.y);
        }
    }
}

//좌표 class
class Coor{
    int x;
    int y;
    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
