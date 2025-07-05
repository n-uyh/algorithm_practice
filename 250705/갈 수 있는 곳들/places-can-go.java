import java.util.*;
import java.io.*;
public class Main {

    static int n, k;
    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int[][] grid, starts;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 격자 크기
        k = Integer.parseInt(st.nextToken()); // 시작점 개수

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                grid[i][j] = Integer.parseInt(st.nextToken()); // 0: 이동 가능, 1: 이동 불가
        }

        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i][0] = Integer.parseInt(st.nextToken()) - 1;
            starts[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        visited = new boolean[k][n][n];
        for (int i = 0; i < k; i++) {
            bfs(i);
        }

        System.out.println(countVisited());

    }

    public static int countVisited() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    if (visited[p][i][j]) {
                        count++; 
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void bfs(int starter) {
        int[] s = starts[starter];

        Queue<int[]> q = new LinkedList<>();
        q.add(s);

        boolean[][] s_visited = visited[starter];
        s_visited[s[0]][s[1]] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            // 상하좌우 이동
            for (int i = 0; i < 4; i++) {
                int newX = node[0] + dx[i];
                int newY = node[1] + dy[i];

                if (canGo(newX, newY) && !s_visited[newX][newY]) {
                    s_visited[newX][newY] = true;
                    q.add(new int[]{newX,newY});
                }
            }
        }
    }

    public static boolean inBoundary(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        return inBoundary(x,y) && grid[x][y] == 0;
    }
   
}