import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        if (m != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = m - 1; j >= 0; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }
    }
}