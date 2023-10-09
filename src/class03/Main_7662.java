package class03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main_7662 {
    private static TreeMap<Integer, Integer> map;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i=0; i<k; i++){
                String[] input = br.readLine().split(" ");
                String method = input[0];
                int param = Integer.parseInt(input[1]);

                if (method.equals("I")){
                    map.put(param, map.getOrDefault(param, 0)+1);
                }
                else{
                    if (map.size()==0){
                        continue;
                    }

                    int target = param==1 ? map.lastKey() : map.firstKey();
                    if (map.get(target)==1){
                        map.remove(target);
                    }else{
                        map.put(target, map.get(target)-1);
                    }

                }
            }
            //input end
            if (map.size()==0){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(map.lastKey()+" "+map.firstKey()+"\n");
            }
        }

        System.out.print(sb);
    }//main
//    private static void solve(String s, int p){
//        if (s.equals("I")){ //queue 삽입
//            maxHeap.offer(p);
//            minHeap.offer(p);
//        }
//        else if(s.equals("D") && maxHeap.size()!=0){ //queue 삭제
//            if (p==1){ //최대값 삭제
//                int target = maxHeap.poll();
//                //remove -> 순차적으로 인덱스에 접근함 : O(N) 시간초과
//                minHeap.remove(target);
//            }
//            else if (p==-1){ //최솟값 삭제
//                int target = minHeap.remove();
//                maxHeap.remove(target);
//            }
//        }
//    }
}//Class
