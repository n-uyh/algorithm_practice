import java.io.*;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static List<Integer>[] believe;
    static boolean[] visited;
    static int[] count;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        believe = new List[n+1];
        count = new int[n+1];

        for (int i = 0; i <= n; i++) {
            believe[i] = new ArrayList<>(); // 인접리스트 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            believe[a].add(b); // a가 b를 신뢰한다 -> b가 신뢰당한다
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            count[i]++;
            dfs(i); // 재귀함수
        }


        int max = Arrays.stream(count).max().getAsInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1 ; i++) {
            if (count[i] == max) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);

    }

    static void dfs(int n) {
        for (int next : believe[n]) {
            if (!visited[next]) { // 아직 방문하지 않은 경우
                visited[next] = true; // 방문처리
                count[next]++; // 연관되어서 한번에 해킹되는 친구이므로 더해줌
                dfs(next); // 재귀
            }
        }
    }

}
