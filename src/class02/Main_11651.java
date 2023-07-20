package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11651 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //Coordinate class 배열
        Coordinate[] coorList = new Coordinate[N];

        for (int i=0; i<N; i++){
            var input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            coorList[i] = new Coordinate(x,y);
        }
        //좌표객체 정렬
        Arrays.sort(coorList, (o1, o2)-> {
                if (o1.getY() == o2.getY()){
                    return Integer.compare(o1.getX(), o2.getX());
                }else{
                    return Integer.compare(o1.getY(), o2.getY());
                }
        });

        //출력
        for (var item:coorList){
            System.out.println(item.toString());
        }
    }
}
//좌표 class
class Coordinate{
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    @Override
    public String toString() {
        String str = "%d %d".formatted(this.x, this.y);
        return str;
    }
}
