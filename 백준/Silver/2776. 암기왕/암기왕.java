import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int j = 0; j < T; j++) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            Set<Integer> note1 = new TreeSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                note1.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                sb.append(note1.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }

            System.out.print(sb);
        }
    }

}