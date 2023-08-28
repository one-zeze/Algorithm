package unit_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Escape_test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input.split("\\+");
        StringTokenizer st = new StringTokenizer(input, "+");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());

        }
    }
}
