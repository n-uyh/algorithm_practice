import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        for (int i = a; i <= b; i++) {
            if (condition1(i) && isPrime(i)) result++;
        }
        System.out.println(result);
    }

    // 모든 자릿수의 합이 짝수인지 체크하는 함수
    public static boolean condition1(int a) {
        return ((int) (a / 10) + (a % 10)) % 2 == 0;
    }

    // 소수판별함수
    public static boolean isPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}