import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.print(searchMaxCoin());
    }

    public static int searchMaxCoin() {
        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                max = Math.max(max,countCoin(i,j));
            }
        }
        return max;
    }

    public static int countCoin(int x, int y) {
        int count = 0;
        for (int i = x; i <= x+2; i++) {
            for (int j = y; j <= y+2; j++) {
                count += grid[i][j];
            }
        }
        return count;
    }
}