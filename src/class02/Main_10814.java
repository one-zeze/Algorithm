package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10814 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];

            members[i] = new Member(age, name);
        }

        //정렬
        Arrays.sort(members, (m1, m2) -> {
            if (m1.age == m2.age){
                return Integer.compare(m1.member_id, m2.member_id);
            }else{
                return Integer.compare(m1.age, m2.age);
            }
        });

        for (var m:members){
            System.out.println(m.age+" "+m.name+" "+m.member_id);
        }
    }
}

class Member{
    private static int member_num = 0;
    String name;
    int age;
    int member_id;

    public Member(int age, String name){
        this.age = age;
        this.name = name;
        this.member_id = member_num;
        member_num++;
    }
}
