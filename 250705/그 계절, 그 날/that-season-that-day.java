import java.util.Scanner;
public class Main {

    // 윤년 판별
    public static boolean isLeapYear(int y) {
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                return y % 400 == 0;
            }
            return true;
        }
        return false;
    }

    // 각 월의 마지막 날짜 
    public static int lastDayOfMonth(int y, int m) {
        if (m == 2) {
            return isLeapYear(y) ? 29 : 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    // 존재하는 날짜인가?
    public static boolean isCorrectDate(int y, int m, int d) {
        return d <= lastDayOfMonth(y,m);
    }

    public static String season(int m) {
        if (3 <= m && m <= 5) {
            return "Spring";
        } else if (6 <= m && m <= 8) {
            return "Summer";
        } else if (9 <= m && m <= 11) {
            return "Fall";
        } else {
            return "Winter";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(isCorrectDate(y,m,d) ? season(m) : -1);
    }
}