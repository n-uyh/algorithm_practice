import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        System.out.println(isLeaf(y));
    }

    public static boolean isLeaf(int year) {
        if (year % 4 == 0) {
            return !(year % 100 == 0 && year % 400 != 0);
        }
        return false;
    }
}