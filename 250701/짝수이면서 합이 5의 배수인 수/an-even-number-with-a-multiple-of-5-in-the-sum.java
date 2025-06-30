import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = isMeetCondition(n) ? "Yes" : "No";
        System.out.println(result);
    }

    public static boolean isMeetCondition(int n) {
        return n % 2 == 0 && condition2(n);
    }

    // 각 자리 숫자 합이 5의 배수인지 판단
    public static boolean condition2(int n) {
        return ((int) (n / 10) + (n % 10)) % 5 == 0;
    }
}