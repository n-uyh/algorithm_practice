import java.util.Scanner;
public class Main {
    static String text;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        text = sc.next();
        String pattern = sc.next();

        System.out.println(findIndex(pattern));
    }

    public static int findIndex(String pattern) {
        return text.indexOf(pattern);
    }
}