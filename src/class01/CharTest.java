package class01;

public class CharTest {
    public static void main(String[] args){

        StringBuilder sb = new StringBuilder();
        String str = "ABC";

//        System.out.println(str.length());
//        System.out.println(str.charAt(0));
        for (int i=0; i<str.length(); i++){
            for (int j=0; j<str.length(); j++){
                sb.append(str.charAt(i));
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }
}
