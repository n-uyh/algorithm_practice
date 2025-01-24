import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int n, m;
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> songs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String title = st.nextToken();
            String key = st.nextToken() + st.nextToken() + st.nextToken();
            List<String> value = songs.getOrDefault(key, new ArrayList<>());
            value.add(title);
            songs.put(key, value);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String findKey = br.readLine().replaceAll(" ", "");
            List<String> findValues = songs.get(findKey);
            if (findValues == null || findValues.isEmpty()) {
                sb.append('!');
            } else if (findValues.size() == 1) {
                sb.append(findValues.get(0));
            } else {
                sb.append('?');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
