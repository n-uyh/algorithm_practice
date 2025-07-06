import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        System.out.print(check(A));
    }

    public static String check(String s) {
        char first = s.charAt(0);
        for (int i = 1; i < s.length() ; i++) {
            if (first != s.charAt(i)) return "Yes";
        }
        return "No";
    }
}