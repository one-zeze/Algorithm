package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MineCraft {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer row = Integer.parseInt(st.nextToken());
        Integer col = Integer.parseInt(st.nextToken());
        Integer block = Integer.parseInt(st.nextToken());
        int[][] ground = new int[row][col];
        int min = 256;
        int max = 0;
        //블록 최대,최소 높이 구하기
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                if (ground[i][j] < min) {
                    min = ground[i][j];
                }
                if (ground[i][j] > max) {
                    max = ground[i][j];
                }
            }
        }

        int min_time = 1000000000;
        int max_height = 0;
        Loop1:
        for (int height = min; height <= max; height++) {
            int del_count = 0;
            int ins_count = 0;
            int temp_b = block;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    if (ground[i][j] < height) {
                        ins_count += height - ground[i][j];
                        temp_b -= height - ground[i][j];

                    } else if (ground[i][j] > height) {
                        del_count += ground[i][j] - height;
                        temp_b += ground[i][j] - height;
                    }
                }
            }
            if (temp_b < 0) {
                continue Loop1;
            }
            int time = del_count * 2 + ins_count;
            if (time <= min_time && height >= max_height) {
                min_time = time;
                max_height = height;
            }
        }

        System.out.println(min_time + " " + max_height);
    }
}