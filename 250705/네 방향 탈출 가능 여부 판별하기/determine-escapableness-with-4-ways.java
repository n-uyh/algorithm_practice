import java.util.*;
public class Main {

    // 상하좌우로 이동
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int n, m;
    static int[][] grid;

    static Queue<int[]> q = new LinkedList<>();;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        // 격자 초기화, 1이면 뱀있음
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        q.add(new int[]{0,0});
        visited = new boolean[n][m];
        System.out.println(bfs());
    }

    

    // bfs 탐색
    public static int bfs() {
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0] == n - 1 && c[1] == n -1) return 1;

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = c[0] + dx[i];
                int nextY = c[1] + dy[i];

                if (canGo(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY});
                }
            }
        }
        return 0;
    }

    // 격자 내부에 있는지 확인
    public static boolean inBoundary(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < m;
    }

    // 갈 수 있는지 확인(뱀이 없는지)
    public static boolean canGo(int x, int y) {
        return inBoundary(x,y) && grid[x][y] == 1; 
    }

}