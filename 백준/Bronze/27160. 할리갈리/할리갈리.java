import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        Map<String, Integer> cards = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            cards.put(key, cards.getOrDefault(key, 0) + count);
        }

        String result = "NO";
        for (Integer value : cards.values()) {
            if (value == 5) {
                result = "YES";
                break;
            }
        }
        System.out.println(result);
    }
}
