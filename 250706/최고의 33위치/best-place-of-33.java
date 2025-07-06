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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!validSubGrid(i,j)) 
                    continue;
                
                max = Math.max(max,countCoin(i,j));
            }
        }
        return max;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }

    public static boolean validSubGrid(int x, int y) {
        return inRange(x,y) && inRange(x,y+2) && inRange(x+2,y) && inRange(x+2,y+2);
    }

    public static int countCoin(int x, int y) {
        int count = 0;
        for (int i = x; i <= x+2; i++) {
            for (int j = y; j <= y+2; j++) {
                if (grid[i][j] == 1)
                    count++;   
            }
        }
        return count;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}