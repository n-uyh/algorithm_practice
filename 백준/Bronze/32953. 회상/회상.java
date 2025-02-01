import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int n, m, result;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<String, Integer> students = new HashMap<>();
        for (int i = 0; i < n; i++) {
            br.readLine(); // 의미 없는 라인
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                students.put(s, students.getOrDefault(s, 0)+1);
            }
        }


        for (String s : students.keySet()) {
            if (students.get(s) >= m) {
                result++;
            }
        }

        System.out.println(result);
    }
}
