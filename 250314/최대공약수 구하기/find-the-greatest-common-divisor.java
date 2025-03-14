import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        System.out.println(greatest(n,m));
    }

    public static int greatest(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        return greatest(m, n%m);
    }
}