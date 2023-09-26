package unit_test;

public class Comparator {
    private static class Student implements java.util.Comparator<Student> {
        int age;
        int classNum;
        public Student(int age, int classNum){
            this.age = age;
            this.classNum = classNum;
        }

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.classNum > o2.classNum){
                return 1;
            }
            else if (o1.classNum == o2.classNum){
                return 0;
            }
            else{
                return -1;
            }
        }
    }

    public static void main(String[] args){


    }
}
