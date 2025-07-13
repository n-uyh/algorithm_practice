import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < m; i++) {
            String target = sc.next();
            if (target.matches("\\d+")) {
                int index = Integer.parseInt(target);
                System.out.println(words[index]);
            } else {
                for (int j = 1; j <= n; j++) {
                    if (target.equals(words[j]))
                        System.out.println(j);
                }
            }
        }
    }


}