import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(getMin(a,b,c));
    }

    public static int getMin(int a, int b, int c) {
        return Math.min(Math.min(a,b),c);
    }
}