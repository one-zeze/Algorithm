package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
//    private static Integer[][] arr;
    private static int idx=0;
    private static int r;
    private static int c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = 2;
        for (int i=1; i<N; i++){
            size *= 2;
        }
//        arr = new Integer[size][size];
//        Z(0, 0, size);
        solve(0, 0, size);
    }

    private static void solve(int x, int y, int size){
        if (size==1){
            System.out.println(idx);
            return;
        }

        int new_size = size/2;
        if (r<x+new_size && c<y+new_size){ //1
//            idx += (size*size)/4 * 0;
            solve(x, y, new_size);
        }
        if (r<x+new_size && y+new_size<=c){ //2
            idx += (size*size)/4;
            solve(x, y+new_size, new_size);
        }
        if (x+new_size<=r && c<y+new_size){ //3
            idx += ((size*size)/4) * 2;
            solve(x+new_size, y, new_size);
        }
        if (x+new_size<=r && y+new_size<=c){ //4
            idx+=((size*size)/4) * 3;
            solve(x+new_size, y+new_size, new_size);
        }
    }

    //메모리 초과 발생
    private static void Z(int x, int y, int size){
        int[] nx = {0,0,1,1};
        int[] ny = {0,1,0,1};

        if (size==2){
            for (int i=0; i<4; i++){
                int newX = x+nx[i];
                int newY = y+ny[i];
//                arr[newX][newY]=idx;
                if (r==newX && c==newY){
                    System.out.println(idx);
                    return;
                }
                idx++;
            }
        }

        int new_size = size/2;
        if (r<x+new_size && c<y+new_size){
//            idx += (size*size)/4 * 0;
            Z(x, y, new_size); //1사분면
        }
        if (r<x+new_size && c>=y+new_size){
            idx += (size*size)/4;
            Z(x, y+new_size, new_size); //2사분면
        }
        if (r>=x+new_size && c<y+new_size){
            idx += (size*size)/4 * 2;
            Z(x+new_size, 0, new_size); //3사분면
        }
        if (r>=x+new_size && c>=y+new_size){
            idx += (size*size)/4 * 3;
            Z(x+new_size, y+new_size, new_size); //4사분면
        }
    }

}
