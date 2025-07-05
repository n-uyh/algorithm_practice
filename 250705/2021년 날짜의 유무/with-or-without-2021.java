import java.util.*;
public class Main {

    static List<Integer> m30 = Arrays.asList(4,6,9,11);

    public static boolean isMonth(int m) {
        return m <= 12; // 입력되는 m이 1 이상이므로 최소는 판단하지 않는다.
    }

    public static int maxDateInMonth(int m) {
        if (m == 2) {
            return 28;
        } else if (m30.contains(m)) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean isDateIn2021(int m, int d) {
        if (isMonth(m)) {
            return d <= maxDateInMonth(m);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(isDateIn2021(m,d) ? "Yes" : "No");
    }
}