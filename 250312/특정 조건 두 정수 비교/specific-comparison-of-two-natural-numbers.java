import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        String result = "";
        result += getResult(A < B);
        result += " ";
        result += getResult(A == B);
        System.out.println(result);
    }

    public static int getResult(boolean condition) {
        if (condition) {
            return 1;
        } else {
            return 0;
        }
    }
}