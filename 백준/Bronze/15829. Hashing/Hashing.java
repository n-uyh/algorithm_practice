import java.util.Scanner;

public class Main {

    public static int l; // 문자열의 길이
    public static int r = 31;
    public static long M = 1234567891;
    public static double result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        sc.nextLine();
        String word = sc.nextLine();


        for (int i = 0; i < l; i++) {
            result += (word.charAt(i) - 96) * Math.pow(r, i);
        }

        System.out.println((long) (result % M));
    }
}
