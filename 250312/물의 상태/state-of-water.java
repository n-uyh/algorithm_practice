import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        String result;
        if (n < 0) {
            result = "ice";
        } else if (n >= 100) {
            result = "vapor";
        } else {
            result = "water";
        }
        System.out.println(result);
    }
}