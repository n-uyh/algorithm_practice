import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result;
        if (a > b) {
            result = a * b;
        } else {
            result = b / a;
        }
        System.out.println(result);
    }
}