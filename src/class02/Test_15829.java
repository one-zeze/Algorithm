package class02;
import java.util.Scanner;

public class Test_15829
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        String s = input.next();

        final int M = 1234567891;

        int sum = 0;

        for (int i=0; i<n; i++)
        {
            int temp = s.charAt(i) - 96;

            Long q = (long) (temp % M);

            for (int j=1; j<=i; j++)
            {
                q *= 31;
                q %= M;
            }

            sum = (int) (((sum % M) + (q % M)) % M);
        }

        System.out.print(sum);
    }
}