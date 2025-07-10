import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k, c;
    static int[][] grid, killers;
    static int[] dr = {0,1,0,-1}, dc = {1,0,-1,0}; // 상하좌우
    static int[] dx = {-1,-1,1,1}, dy = {-1,1,-1,1}; // 대각
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        killers = new int[n][n]; // 제초제 위치 , 유효기간 표시

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // -1 벽, 0 빈칸, 혹은 나무의 수
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // m년간 반복
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // 나무 성장
            growTree();
            // 나무 번식
            cloneTreeAll(i);
            // 제초제 뿌리기 (가장많이 박멸칸 판단, 제초제 그리드 채우기)
            count += setTreeKiller(i);

        }

        System.out.print(count);
    }


    // 나무 성장
    public static void growTree() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    grid[i][j] += countGrowth(i,j);
                }
            }
        }
    }

    // 인접한 칸의 나무있는 칸의 수
    public static int countGrowth(int r, int c) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc) && grid[nr][nc] > 0)
                count++;
        }
        return count;
    }

    // 나무 번식(전체)
    public static void cloneTreeAll(int year) {
        int[][] cloned = new int[n][n];
        copyGrid(grid, cloned);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    cloned = cloneTree(year,i,j,cloned);
                }
            }
        }

        grid = cloned;
    }

    // 나무 번식(한 칸)
    public static int[][] cloneTree(int year, int r, int c, int[][] cloned) {
        // 번식가능한 방향 판단
        List<Integer> dirs = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr,nc) && grid[nr][nc] == 0 && !isKiller(year,nr,nc)) {
                dirs.add(i);
            }
        }

        // 번식
        int cloneCount = grid[r][c];
        if (dirs.size() > 0)
            cloneCount /= dirs.size();

        for (int dir : dirs) {
            cloned[r+dr[dir]][c+dc[dir]] += cloneCount;
        }
        return cloned;
    }

    // 이중 그리드 복사
    public static void copyGrid(int[][] source, int[][] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = Arrays.copyOf(source[i], source[i].length);
        }
    }

    // 해당칸에 제초제가 남아있는지 판별
    public static boolean isKiller(int year, int r, int c) {
        return killers[r][c] >= year;
    }



    // 제초제 뿌리기 => 박멸한 나무의 수 구하기
    public static int setTreeKiller(int year) {
        // 가장 많이 박멸할 수 있는 칸 판단
        int max = 0;
        int mx = 0, my = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !isKiller(year,i,j)) {
                    int kill = countCanKill(i,j);
                    if (max < kill) {
                        max = kill;
                        mx = i;
                        my = j;
                    }
                }
            }
        }

        // 제초제 뿌리기
        spray(mx, my, year);
        return max;
    }

    public static int countCanKill(int x, int y) {
        int count = grid[x][y];
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (inRange(nx,ny) && grid[nx][ny] > 0) {
                    count += grid[nx][ny];
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void spray(int x, int y, int year) {
        grid[x][y] = 0;
        killers[x][y] = year + c;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;

                if (inRange(nx,ny)) {
                    killers[nx][ny] = year + c;
                    if (grid[nx][ny] > 0) {
                        grid[nx][ny] = 0;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }

    // 가장 많이 박멸할 수 있는 칸 판단
    public static boolean inRange(int r, int c) {
        return 0 <= r && r < n
            && 0 <= c && c < n;
    }

}