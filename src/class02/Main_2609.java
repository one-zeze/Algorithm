package class02;

import java.util.Scanner;

public class Main_2609 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(getGCD(A, B));
        System.out.println(getLCM(A, B));
    }

    public static int getGCD(int a , int b){
        int result = 0;
        int cnt =1;

        while (true){
            if (a%cnt==0 && b%cnt==0){
                result = cnt;
                cnt++;
            }else{
                cnt++;
            }

            if (cnt>a || cnt>b){
                break;
            }
        }
        return result;
    }

    public static int getLCM(int a , int b){
        int result = 0;
        int minNum = getGCD(a, b);
        int cnt = 1;

        while(true){
            int multiple = minNum * cnt;

            if (multiple%a==0 && multiple%b==0){
                result = multiple;
                break;
            }else{
                cnt++;
            }
        }
        return result;
    }
}
