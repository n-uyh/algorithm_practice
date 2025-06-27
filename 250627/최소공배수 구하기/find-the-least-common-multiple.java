import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        System.out.println(lcm(n,m));
    }

    // 최대공약수
    public static int gcd(int a, int b) {
        int mod = a % b;
        if (mod != 0) {
            return gcd(b, mod);
        }
        return b;
    }

    // 최소공배수 = a * b / 최대공약수
    public static int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }
}