import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(judgeCondition(A >= B));
        System.out.println(judgeCondition(A > B));
        System.out.println(judgeCondition(A <= B));
        System.out.println(judgeCondition(A < B));
        System.out.println(judgeCondition(A == B));
        System.out.println(judgeCondition(A != B));
    }

    public static int judgeCondition(boolean condition) {
        if (condition) {
            return 1;
        }
        return 0;
    }
}