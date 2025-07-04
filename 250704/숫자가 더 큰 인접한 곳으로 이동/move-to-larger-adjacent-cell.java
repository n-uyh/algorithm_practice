import java.util.Scanner;
public class Main {
    static int n, r, c;
    static int[][] grid;
    // 상, 하, 좌, 우 순서
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // grid 크기
        n = sc.nextInt();
        // 초기 위치
        r = sc.nextInt();
        c = sc.nextInt();

        // grid 생성
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print(grid[r][c] + " ");
        move();
    }

    // 인덱스가 그리드 내부에 있는지 확인
    public static boolean isInGrid(int r, int c) {
        return r <= n && r > 0 && c <= n && c > 0;
    }


    // 다음 칸의 숫자가 더 큰지 확인
    public static boolean isBigThanCurrentCell(int direction) {
        int nextX = r + dr[direction];
        int nextY = c + dc[direction];
        
        if (isInGrid(nextX, nextY)) {
            boolean result = grid[nextX][nextY] > grid[r][c];
            if (result) {
                r = nextX;
                c = nextY;
                return true;
            }
        }
        return false;
    }

    public static void move() {
        for(int d = 0; d < 4; d++) { // 상하좌우칸 탐색
            if (isBigThanCurrentCell(d)) {
                System.out.print(grid[r][c] + " ");
                move();
            }
        }
    }
}
