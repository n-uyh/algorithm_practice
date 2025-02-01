import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 요리 종류의개수 n
    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()); // 필요한 요리재료
        Map<String, Boolean> ingredients = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ingredients.put(st.nextToken(), false);
        }

        st = new StringTokenizer(br.readLine()); // 사용한 요리재료
        for (int i = 0; i < n - 1; i++) {
            ingredients.put(st.nextToken(), true);
        }

        for (String s : ingredients.keySet()) {
            if (!ingredients.get(s)) {
                System.out.println(s);
                break;
            }
        }
    }
}
