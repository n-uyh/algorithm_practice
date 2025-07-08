import java.util.Scanner;
public class Main {
    static int n;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkCondition(i,j)) count++;
            }
        }

        System.out.print(count);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }

    public static boolean checkCondition(int x, int y) {
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx,ny) && arr[nx][ny] == 1) {
                count++;
            }
        }
        return count >= 3;
    }
}