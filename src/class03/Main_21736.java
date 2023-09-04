package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_21736 {
    private static boolean[][] visit;
    private static String[][] location;
    static int N;
    static int M;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] campus_size = br.readLine().split(" ");
        N = Integer.parseInt(campus_size[0]);
        M = Integer.parseInt(campus_size[1]);

        location = new String[N][M];
        visit = new boolean[N][M];
        int doyeon_x = 0;
        int doyeon_y = 0;
        for (int i=0; i<N; i++){
            var input = br.readLine().split("");
            for (int j=0; j<M; j++){
                location[i][j] = input[j];
                if (input[j].equals("I")){
                    doyeon_x = i;
                    doyeon_y = j;
                }
            }
        }
        dfs(doyeon_x, doyeon_y);
        if (result != 0){
            System.out.println(result);
        }else {
            System.out.println("TT");
        }
    }

    private static void dfs(int x, int y){
        int[] move_x = {1,-1,0,0};
        int[] move_y = {0,0,1,-1};

        visit[x][y] = true;
        if (location[x][y].equals("P")){
            result++;
        }

        for (int i=0; i<4; i++){
            int nx = x+move_x[i];
            int ny = y+move_y[i];

            if (nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]){
                if (!location[nx][ny].equals("X")){
                    dfs(nx, ny);
                }
            }
        }
    }

}
