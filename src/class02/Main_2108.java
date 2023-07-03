package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());

        //입력값 배열에 저장
        int[] numList = new int[roop];
        for (int i=0; i<roop; i++){
            numList[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getAvg(numList));
        System.out.println(getMid(numList));
        System.out.println(getMost(numList));
        System.out.println(getDiff(numList));

    }

    //산술평균
    private static Long getAvg(int[] list){
        int sum = 0;

        for (var item:list){
            sum+=item;
        }

        double a = (double)sum / (double)list.length;
        Long result = 0L;
        //음수의 경우 절대값 처리후 반올림후에, 곱하기 -1
        if (a > 0){
            result = Math.round(a);
        } else if (a < 0) {
            a = Math.abs(a);
            result = Math.round(a) * -1;
        }

        return result;
    }
    //중앙값
    private static Integer getMid(int[] list){
        int targetIndex = list.length/2;
        Arrays.sort(list);

        return list[targetIndex];
    }
    //최빈값
    private static Integer getMost(int[] list){
        // 숫자,등장횟수 맵에 저장
        Map<Integer, Integer> map = new HashMap<>();

        //입력값을 오름차순 정렬수 맵에 저장
        Arrays.sort(list);
        for (var item:list){
            int val = map.getOrDefault(item, 0);
            map.put(item, val+1);
        }
        
        //가장 많은 등장횟수 구하기
        var maxVal = Collections.max(map.values());
        int result = 0;
        var keySet = map.keySet();

        //maxVal 값을가진 key가 몇개인지 구하기
        int cnt = 0 ;
        for (var key:keySet){
            if (map.get(key) == maxVal){
                cnt++;
            }
        }
        
        //위 조건을 만족하는 키값 개수만큼 배열 선언
        int[] resultList = new int[cnt];
        
        //maxVal 값을 가진 key들만 배열에 저장
        int index = 0;
        for (var key:keySet){
            if (map.get(key) == maxVal){
                resultList[index] = key;
                index++;
            }
        }
        
        if (resultList.length == 1){
            result = resultList[0];
        }
        else{ //결과가 여러 개 있을때, 정렬후 두번째 값 반환
            Arrays.sort(resultList);
            result = resultList[1];
        }

        return result;
    }
    //범위
    private static Integer getDiff(int[] list){
        int lastIndex = list.length-1;
        Arrays.sort(list);
        int result = list[lastIndex] - list[0];

        return result;
    }
}
