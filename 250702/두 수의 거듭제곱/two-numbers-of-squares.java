import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(pow(a,b));
    }

    public static int pow(int a, int b) {
        return (int) Math.pow(a,b);
    }
}