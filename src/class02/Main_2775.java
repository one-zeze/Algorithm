package class02;

import java.util.Scanner;

public class Main_2775 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        //2층 1 4 10 20 35
        //1층 1 3 6 10 15
        //0층 1 2 3 4 5

        for (int i=0; i<caseNum; i++){
            int k = sc.nextInt(); //층
            int n = sc.nextInt(); //호수

            getPeopleNum(k, n);
        }
    }

    public static void getPeopleNum(int k, int n){
        int result = 0;
        int[] baseFloor = new int[n];
        int[] nextFloor = new int[n];

        //0층
        for (int i=1; i<=n; i++){
            baseFloor[i-1] = i;
        }

        for (int j=0; j<k; j++){
            int people = 0;
            for (int z=0; z<n; z++){
                people += baseFloor[z];
                nextFloor[z] = people;
            }
            baseFloor = nextFloor;
            result = nextFloor[n-1];
        }

        System.out.println(result);
    }
}
