import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printSquare(n);
    }

    public static int mod9(int target) {
        int result = target % 9;
        if (result == 0) {
            result = 9;
        }
        return result;
    }

    public static void printSquare(int n) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mod9(++number)).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}