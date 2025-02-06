import java.util.*;

public class Main {

    static int[] moveRow = {1, 0, 1, -1}; // row가 움직일 방향
    static int[] moveCol = {0, 1, 1, 1}; // col가 움직일 방향
    static int[][] grid = new int[19][19]; // 바둑판
    static boolean[][][] visited = new boolean[19][19][4]; // 방문여부
    static int count; //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < 19; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                for (int k = 0; k < 4; k++) {
                    if (grid[i][j] > 0 && !visited[i][j][k]) {
                        count = 0;
                        dfs(i, j, k);
                        if (count == 5) {
                            if (k == 3 && j > 0 && i < 18) {
                                if (grid[i+1][j-1] == grid[i][j]){
                                    continue;
                                }
                            }
                            System.out.println(grid[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return ;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    static void dfs(int row, int col, int direction) {
        visited[row][col][direction] = direction != 3; // direction 3은 예외로.. 
        count++;

        int now = grid[row][col];
        if (now == 0) {
            count = 0;
            return ;
        }

        int newX = row + moveRow[direction];
        int newY = col + moveCol[direction];

        boolean validX = newX >= 0 && newX < 19;
        boolean validY = newY >= 0 && newY < 19;
        if (validX && validY) {
            if (grid[newX][newY] == now && !visited[newX][newY][direction]) {
                dfs(newX, newY, direction);
            }
        }
    }

}
