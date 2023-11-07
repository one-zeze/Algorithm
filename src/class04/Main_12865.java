package class04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865 {
    static class Stuff {
        int weight;
        int V;

        public Stuff(int weight, int v) {
            this.weight = weight;
            this.V = v;
        }
    }
    private static Stuff[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); //물건 개수
        int K = Integer.parseInt(st.nextToken()); //최대 무게
        list = new Stuff[N];


        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int W = Integer.parseInt(input[0]); //물건 무게
            int V = Integer.parseInt(input[1]); //가치

            list[i] = new Stuff(W, V);
        }
        //end input
        fillBag(K);
    }
    
    private static void fillBag(int K){
        //탑다운으로 고민해보자
    }
}//class
