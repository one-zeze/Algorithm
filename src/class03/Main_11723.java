package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_11723 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0){
            String[] input = br.readLine().split(" ");
            String method = input[0];

            switch (method){
                case "add":
                    set.add(Integer.parseInt(input[1]));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(input[1]));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(input[1]))){
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if (set.contains(Integer.parseInt(input[1]))){
                        set.remove(Integer.parseInt(input[1]));
                    }
                    else{
                        set.add(Integer.parseInt(input[1]));
                    }
                    break;
                case "all":
                    set.clear();
                    for (int i=1; i<=20; i++){
                        set.add(i);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
