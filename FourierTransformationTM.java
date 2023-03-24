import java.util.Scanner;

public class FourierTransformationTM {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int t = key.nextInt();
        while (t-- > 0) {
            int n = key.nextInt();
            int fouriest = 0, base = 0;
            for (int i = 2; i <= 36; i++) {
                int count = 0, temp = n;
                while (temp > 0) {
                    if (temp % i == 4) {
                        count++;
                    }
                    temp /= i;
                }
                if (count > fouriest || (count == fouriest && i > base)) {
                    fouriest = count;
                    base = i;
                }
            }
            System.out.printf("%d %s\n", base, Integer.toString(n, base).toUpperCase());
        }
    
    }
}
