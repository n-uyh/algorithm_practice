import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(divide10(n));
    }

    public static int divide10(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return (int) result / 10;
    }
}