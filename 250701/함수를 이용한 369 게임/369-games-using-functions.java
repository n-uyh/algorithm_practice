import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = 0;
        for (int i = A; i <= B; i++) {
            if (checkCondition(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean checkCondition(int n) {
        return n % 3 == 0 || condition2(n);
    }

    public static boolean condition2(int target) {
        int r = (int) Math.log10(target) + 1; // 자릿수
        for (int i = 0; i < r; i++) {
            int a = (int) (target / Math.pow(10,i)) % 10;
            if (a == 3 || a == 6 || a == 9) {
                return true;
            }
        }
        return false;
    }
}