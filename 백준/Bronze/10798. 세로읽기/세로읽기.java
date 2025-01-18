import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 5;
        int len = 15;
        char[][] arr = new char[cnt][len];
        for (int i = 0; i < cnt; i++) {
            String s;
            do {
                s = sc.nextLine();
            } while (s == null || s.equals(""));
            arr[i] = s.toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < cnt; j++) {
                if (arr[j].length <= i) {
                    continue;
                }
                sb.append(arr[j][i]);
            }
        }

        System.out.println(sb);
    }
}
