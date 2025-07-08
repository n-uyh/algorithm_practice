import java.util.*;
import java.io.*;
public class Main {
    static int n,m,k;
    static int[][] grid;
    static boolean[][] visited;
    static List<List<Pair>> teams = new ArrayList<>(); 

    static class Pair {
        int x;
        int y;
        int[] dx = {0,-1,0,1};
        int[] dy = {1,0,-1,0};
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean inRange() {
            return 0 <= x && x < n 
                && 0 <= y && y < n;
        }

        public Pair newPair(int d) {
            return new Pair(x+dx[d], y+dy[d]);
        }

        public int grid() {
            return grid[x][y];
        }

        public Pair nextHead() {
            for (int i = 0; i < 4; i++) {
                Pair np = newPair(i);
                if (np.inRange() && (np.grid() == 3 || np.grid() == 4)) {
                    return np;
                }
            }
            return this;
        }

        public void print() {
            System.out.printf("(%d, %d)", x, y);
        }
    }

    // 입력받기
    public static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 라운드 수

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
    }

    // 팀구성
    public static void buildTeam(List<Pair> team, Pair p) {
        for (int i = 0; i < 4; i++) {
            Pair np = p.newPair(i);

            if (!np.inRange() || visited[np.x][np.y]) continue;

            visited[np.x][np.y] = true;
            if (p.grid() == 1 && np.grid() == 2) {
                team.add(p);
                team.add(np);
                buildTeam(team, np);
            } else if (np.grid() == 2 || np.grid() == 3) {
                team.add(np);
                buildTeam(team, np);
            }
        }

    }

    // 라운드별 팀별 이동
    public static void moveTeams() {
        List<List<Pair>> newTeam = new ArrayList<>();
        for (List<Pair> team : teams) {
            List<Pair> moved = new ArrayList<>();
            moved.add(team.get(0).nextHead());
            moved.addAll(team.subList(0,team.size()-1));
            newTeam.add(moved);

            Pair newHead = moved.get(0);
            Pair last = team.get(team.size()-1);
            grid[newHead.x][newHead.y] = 1;
            grid[last.x][last.y] = 4;
        }
    }

    public static int throwBall(int round) {
        // 공 던져질 시작점, 방향
        round %= (4*n);

        Pair start;
        int dir;
        if (round <= n) {
            start = new Pair(round-1,0);
            dir = 0;
        } else if (n < round && round <= 2*n) {
            start = new Pair(round-n,round-n);
            dir = 1;
        } else if (2*n < round && round <= 3*n) {
            start = new Pair(3*n-round,n-1);
            dir = 2;
        } else {
            start = new Pair(0,4*n-round);
            dir = 3;
        }

        // 최초로 만나는 사람
        for (int i = 0; i < n; i++) {
            Pair cell = start.newPair(i);
            if (cell.inRange() && cell.grid() == 1) { // 사람인 경우
                // 점수계산
                cell.print();
                break;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        // 입력
        initInput();

        // 팀구성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<Pair> team = new ArrayList<Pair>();
                    teams.add(team);
                    buildTeam(team, new Pair(i,j));
                }
            }
        }

        // 격자에서 사람을 1로 대체
        for (List<Pair> team : teams) {
            for (Pair p : team) {
                grid[p.x][p.y] = 1;
            }
        }


        int score = 0;
        // 라운드 k번 반복
        for (int r = 0; r < k; r++) { 
            // 팀별 이동
            moveTeams();

            // 공던져짐 + 방향전환 + 점수리턴
            score += throwBall(r);
        }
        System.out.print(score);
    }

    public static void printTeam(List<Pair> team) {
        System.out.print("[");
        for (Pair p : team) {
            p.print();
        }
        System.out.print("]");
    }

    public static void printGrid() {
        for (int[] r : grid) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

}