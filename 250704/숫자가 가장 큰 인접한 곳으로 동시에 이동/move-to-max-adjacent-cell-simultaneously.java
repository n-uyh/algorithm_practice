import java.util.Scanner;
public class Main {
    static int n, m, t;
    static int[][] grid, marbles;

    // 상하좌우
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기
        m = sc.nextInt(); // 최초 구슬 개수
        t = sc.nextInt(); // 시간(시도 횟수)

        // 격자 초기화
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        // 처음 구슬의 위치
        marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            marbles[i][0] = sc.nextInt() - 1;
            marbles[i][1] = sc.nextInt() - 1;
        }

        // t회 시도
        for (int i = 0; i < t; i++) {
            moveMarbles();
        }

        System.out.println(m);
    }

    // 비교할 위치가 그리드 영역 내부에 있는지 확인
    public static boolean isInBound(int x, int y) {
        return x >= 0 && x < n 
            && y >= 0 && y < n;
    }

    // 구슬하나 움직이기
    public static void moveOne(int x, int y, int[][] nextGrid) {
        int origin = grid[x][y];

        int maxX = x, maxY = y;
        int max = origin;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (!isInBound(nextX,nextY)) continue; // 움직일 수 없는 경우 다음 탐색 진행

            if (grid[nextX][nextY] > max) {
                max = grid[nextX][nextY];
                maxX = nextX;
                maxY = nextY;
            }
        }

        nextGrid[maxX][maxY]++;
    }

    // 구슬 동시에 움직인 결과 가져오기
    public static int[][] getNextGrid() {
        int[][] nextGrid = new int[n][n];

        for (int i = 0; i < m; i++) {
            int r = marbles[i][0];
            int c = marbles[i][1];
            moveOne(r,c, nextGrid);
        }

        return nextGrid;
    }

    // 원래 grid로 복사, 
    public static void moveMarbles() {
        int marbleCount = 0;
        int[][] nextGrid = getNextGrid();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = nextGrid[i][j];
                if (count == 1) {
                    // 구슬위치 기록
                    marbles[marbleCount][0] = i;
                    marbles[marbleCount][1] = j;

                    marbleCount++;
                }
            }
        }
        
        m = marbleCount;
    }
}