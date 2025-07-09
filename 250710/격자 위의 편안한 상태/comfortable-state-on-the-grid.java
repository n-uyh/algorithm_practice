import java.util.Scanner;
public class Main {
    static int n, m;
    static boolean[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            grid[r][c] = true;
            isComfortable(r,c);
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n 
            && 0 <= c && c < n;
    }

    // 편안한 상태에 있는지 확인
    public static void isComfortable(int r, int c) {
        int[] dr = {0,1,0,-1}, dc = {1,0,-1,0};

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc) && grid[nr][nc]) count++;
        }
        System.out.println(count == 3 ? 1 : 0);
    }
}