import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        Map<String,Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i],i);
        }

        for (int i = 0; i < m; i++) {
            String target = sc.next();
            if (target.matches("\\d+")) {
                System.out.println(words[Integer.parseInt(target)]);
            } else {
                System.out.println(map.get(target));
            }
        }
    }


}