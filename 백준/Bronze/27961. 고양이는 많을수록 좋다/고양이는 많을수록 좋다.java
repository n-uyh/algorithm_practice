import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print(findPow(n));
    }

    static int findPow(long n) {
        if (n <= 1) {
            return (int) n;
        }
        long x = 0;
        int i = 0;
        while (x < n) {
            i++;
            x = (long) Math.pow(2,i);
        }
        return i+1;
    }

}