import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        boolean isPalindrome = input.equals(flip(input));
        System.out.print(isPalindrome ? "Yes" : "No");
    }

    public static String flip(String target) {
        String flipped = "";
        int len = target.length() - 1;
        for (int i = 0; i <= len; i++) {
            flipped += target.charAt(len - i);
        }
        return flipped;
    }
}