import java.util.*;

public class Main {
    static int n;
    static int[][] grid, visited;
    static int people;
    static List<Integer> village = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();


        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isVillage(i,j)) {
                    visited[i][j] = 1;
                    people = 1;

                    dfs(i,j);
                    village.add(people);
                }
            }
        }

        System.out.println(village.size());
        Collections.sort(village);
        for (int p : village) {
            System.out.println(p);
        }
    }

    public static void bfs(int x, int y, int v) {

    }

    public static void dfs(int x, int y) {
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isVillage(nx,ny)) {
                visited[nx][ny] = 1;
                people++;
                dfs(nx,ny);
            }
        }
    }

    public static boolean isVillage(int x, int y) {
        return inRange(x,y) && visited[x][y] == 0 && grid[x][y] == 1;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }


}