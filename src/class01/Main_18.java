package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main_18 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[10];

        for (int i=0; i<10; i++){
            var input = Integer.parseInt(br.readLine());
            list[i] = input % 42;
        }

        Set<Integer> set = new HashSet<Integer>();
//        Iterator<int[]> iter = set.iterator();
//        while (iter.hasNext()){
//            System.out.print(iter.next()+" ");
//        }
        for(var item : list){
            System.out.print(item+" ");
            set.add(item);
        }

//        System.out.println(set.toString());
        System.out.println(set.size());
    }
}
