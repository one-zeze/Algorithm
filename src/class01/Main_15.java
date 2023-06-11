package class01;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Main_15 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        String[] word = sc.next().toUpperCase().split("");
        for(String str : word){
//            System.out.println(str);
            if (map.containsKey(str)){
                map.replace(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
        }
//        System.out.println(map);
        Collection<Integer> values = map.values();
        int max = Collections.max(values);
//        System.out.println(max);

        String result = "";
        int count = 0;
        for (Map.Entry<String, Integer> entrySet : map.entrySet()){
            var key = entrySet.getKey();
            var val = entrySet.getValue();
            
           if(val == max){
               count+=1;
               result = key;
           }
        }

        if (count > 1){
            System.out.println("?");
        }else {
            System.out.println(result);
        }
    }
}
