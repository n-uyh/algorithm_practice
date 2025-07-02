import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = 0;
        for (int i = A; i <= B; i++) {
            if (isOnjeonsu(i)) result++;
        }
        System.out.println(result);
    }

    public static boolean isOnjeonsu(int a) {
        return a % 2 != 0 && a % 10 != 5 && (a % 3 != 0 || a % 9 == 0);
    }
}