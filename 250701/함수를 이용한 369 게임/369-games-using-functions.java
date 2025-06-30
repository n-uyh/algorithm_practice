import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int result = 0;
        for (int i = A; i <= B; i++) {
            if (checkCondition(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean checkCondition(int n) {
        return n % 3 == 0 || isContains(n+"");
    }

    public static boolean isContains(String target) {
        return target.indexOf('3') > -1 || target.indexOf('6') > -1 || target.indexOf('9') > -1;
    }
}