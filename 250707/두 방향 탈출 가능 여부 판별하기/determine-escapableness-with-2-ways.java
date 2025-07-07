import java.util.Scanner;
public class Main {
    static int[] dr = {1,0}, dc = {0,1};
    static int n,m;
    static int[][] grid, visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt(); // 뱀있으면 0

        visited = new int[n][m];
        visited[0][0] = 1;
        dfs(0,0);
        System.out.print(visited[n-1][m-1]);
    }

    public static void dfs(int r, int c) {
        for (int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (canGo(nr, nc)) {
                visited[nr][nc] = 1;
                dfs(nr,nc);
            }
        }
    }

    public static boolean canGo(int r, int c) {
        return inRange(r,c) && visited[r][c] == 0 && grid[r][c] != 0;
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n 
            && 0 <= c && c < m;
    }
}