import java.util.Scanner;
public class Main {
    static int n, m, q;
    static int[][] building, queries;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();

        queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt() - 1;


        for (int i = 0; i < q; i++) {
            int[] wind = queries[i];
            // 회전
            rotate(wind[0], wind[1], wind[2], wind[3]);
            // 평균값으로 값 대체
            newBuilding(wind[0], wind[1], wind[2], wind[3]);
        }

        printBuilding();
    }

    // 경계회전
    public static void rotate(int r1, int c1, int r2, int c2) {
        // 윗줄 오른쪽 이동
        int temp = building[r1][c2];
        for (int i = c2; i > c1; i--) {
            building[r1][i] = building[r1][i-1];
        }
        for (int i = r1; i < r2; i++) {
            building[i][c1] = building[i+1][c1];
        }
        for (int i = c1; i < c2; i++) {
            building[r2][i] = building[r2][i+1];
        }
        for (int i = r2; i > r1; i--) {
            building[i][c2] = building[i-1][c2];
        }
        building[r1+1][c2] = temp;
    }

    // 값 대치 - 전체
    public static void newBuilding(int r1, int c1, int r2, int c2) {
        int[][] newArea = newArea(r1,c1,r2,c2);
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                building[i][j] = newArea[i][j];
            }
        }
    }

    // 대체 영역 구하기
    public static int[][] newArea(int r1, int c1, int r2, int c2) {
        int[][] newArea = new int[n][m];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                newArea[i][j] = substituteValue(i,j);
            }
        }
        return newArea;
    }

    // 값 대치 - 한칸
    public static int substituteValue(int r, int c) {
        int count = 1;
        int total = building[r][c];
        // 상하좌우 이동
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i], ny = c + dy[i]; 
            if (inRange(nx,ny)) {
                count++;
                total += building[nx][ny];
            }
        }
        return total / count;
    }

    // 영역 내부 
    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n 
            && 0 <= c && c < m;
    }

    public static void printBuilding() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ",building[i][j]);
            }
            System.out.println();
        }
    }
}