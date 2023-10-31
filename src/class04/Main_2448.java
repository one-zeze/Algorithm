package class04;

import java.util.Scanner;

public class Main_2448 {
    static StringBuilder sb = new StringBuilder();
    static Character[][] tree;
    static int N;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        //end input
        tree = new Character[N][(2*N)-1];
        for (int i=0; i<tree.length; i++){
            for (int j=0; j<tree[0].length; j++){
                tree[i][j] = ' ';
            }
        }
        countingStar(0, N-1, N);

        for (int i=0; i< tree.length; i++){
            for (int j=0; j<tree[0].length; j++){
                sb.append(tree[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }//main
    // 별 : 1->2->5 반복
    // N=3    N=6     N=12    N=24
    // k=0:5, k=1:11, k=2:23, k=3:47
    // 가로 : (2*N)-1
    // 세로 : N

    //별 시작점 : 1, 4, 7, 10.... : (3*N)-2
    //별 중간 : 2, 5, 8.... : (3*N)-1
    //별 바닥 : 3, 6, 9 .... : 3*N
    private static void countingStar(int x, int y, int N){
        if (N==3){
            tree[x][y] = '*';
            tree[x+1][y-1] = tree[x+1][y+1] = '*';
            tree[x+2][y-2] = tree[x+2][y-1] = tree[x+2][y] = tree[x+2][y+1] = tree[x+2][y+2] = '*';
            return;
        }
        countingStar(x,y,N/2);
        countingStar(x+N/2,y-N/2,N/2);
        countingStar(x+N/2,y+N/2,N/2);
    }
}
