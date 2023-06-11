package class01;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();
        map.put("item1", 1);
        map.put("item2", 2);
        map.put("item3", 3);
        map.put("item4", 3);

//        System.out.println(map);
//        System.out.println(map.get("item1"));
//        System.out.println(map.getOrDefault("item4", 0)); //해당 키값이 없으면 default값 반환

//        map.forEach((k,v) -> System.out.println("key: %s, value: %d".formatted(k,v)));

        for(Map.Entry<String, Integer> entrySet : map.entrySet()){
//            System.out.println(entrySet.getKey()+":"+entrySet.getValue());
            var key = entrySet.getKey();
            var val = entrySet.getValue();

            if(val == 3){
                System.out.println(key);
            }
        }

//        Collection<Integer> values = map.values();
//        System.out.println(values);
//        System.out.println(Collections.max(values));
//        System.out.println(Collections.min(values));
    }
}
