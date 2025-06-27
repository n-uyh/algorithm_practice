import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        System.out.println(lcm(n,m));
    }

    public static int gcd(int a, int b) {
        int mod = a % b;
        if (mod != 0) {
            gcd(b, mod);
        }
        return mod;
    }

    public static int lcm(int a, int b) {
        int gcd = a >= b ? gcd(a,b) : gcd(b,a);
        return (a*b)/gcd;
    }
}