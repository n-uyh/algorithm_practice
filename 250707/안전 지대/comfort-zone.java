import java.util.Scanner;
public class Main {
    static int n, m, safe;
    static int[][] grid, visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt(); // 집의 높이
            }
        }        

       
        int max_safe = 0;
        int max_safe_k = 0;
        for (int k = 1; k < 100; k++) {
            visited = new int[n][m];
            safe = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isSafe(i,j,k)) {
                        safe++;
                        visited[i][j] = 1;
                        dfs(i,j,k);
                    }
                }
            }

            if (safe > max_safe) {
                max_safe = safe;
                max_safe_k = k;
            }
        }

        System.out.printf("%d %d",max_safe_k, max_safe);
    }

    public static void dfs(int x, int y, int k) {
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isSafe(nx,ny,k)) {
                visited[nx][ny] = 1;
                dfs(nx,ny,k);
            }
        }
    }

    public static boolean isSafe(int x, int y, int k) {
        return inRange(x,y) && visited[x][y] == 0 && grid[x][y] > k;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < m;
    }


}