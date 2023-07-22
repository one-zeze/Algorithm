package class02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Person{
    private int weight;
    private int height;
    public int bodyGrade;

    public Person(String[] info) {
        this.weight = Integer.parseInt(info[0]);
        this.height = Integer.parseInt(info[1]);
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "weight=" + weight +
                ", height=" + height +
                ", bodyGrade=" + bodyGrade +
                '}';
    }
}
public class Main_7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] personList = new Person[N];

        for (int i=0; i<N; i++){
            String[] info = br.readLine().split(" ");
            personList[i] = new Person(info);
        }

        for (int i=0; i<N; i++){
            Person p1 = personList[i];
            int cnt = 1;

            for (int j=0; j<N; j++){
                if (i==j){continue;}

                Person p2 = personList[j];
                if (p1.getWeight() < p2.getWeight() && p1.getHeight() < p2.getHeight()){
                    cnt++;
                }
            }
            p1.bodyGrade = cnt;
        }

        for (var p:personList){
            System.out.print(p.bodyGrade+" ");
        }

    }
}
