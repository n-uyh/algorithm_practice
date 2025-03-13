import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        print(n);
    }

    public static void print(int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.println("12345^&*()_");
        }
    }
}