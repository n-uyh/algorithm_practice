import java.util.*;
public class Main {

    static int n, m, h, k;
    static int[][] hiders;
    static boolean[][] trees;

    // 술래 방향전환 순서 - 상우하좌
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    // 술래의 위치
    static int sx, sy;
    // 술래가 바라보는 방향 상우하좌(0,1,2,3)
    static int sd = 0;


    public static void main(String[] args) {
        // 값 입력 받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기
        m = sc.nextInt(); // 도망자의 수
        h = sc.nextInt(); // 나무의 수
        k = sc.nextInt(); // 진행할 턴 횟수

        hiders = new int[m][3]; // m번째 사람의 위치, 이동방법
        trees = new boolean[n][n];
        // 술래의 현재 위치
        sx = n / 2;
        sy = n / 2;

        // 도망자 위치, 이동방법
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int d = sc.nextInt(); // 1: 우좌, 2: 하상
            hiders[i][0] = x;
            hiders[i][1] = y;
            hiders[i][2] = d;
        }

        // 나무 위치
        for (int i = 0; i < h; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            trees[x][y] = true;
        }

        // 턴 반복
        int score = 0;
        for (int t = 1; t <= k; t++) {
            score += t * play1turn();
        }

        System.out.print(score);
    }

    // 도망자 움직임
    public static void moveHider() {
        // m명만큼 반복
        for (int i = 0; i < m; i++) {
            // i번째 도망자
            int[] hider = hiders[i]; 
            int x = hider[0], y = hider[1], d = hider[2];

            // 1. 움직일 수 있는지 판단 - 술래와 거리 3 이하 일 때만 움직일 수 있음
            int distance = Math.abs(sx-x) + Math.abs(sy-y);
            if (distance <= 3) {
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (!inRange(newX,newY)) {
                    // 원래방향으로 진행못하면 방향전환
                    d = (d + 2) % 4;
                    newX = x + dx[d];
                    newY = y + dy[d];
                }

                // 이동방향으로 1칸 움직임
                hider[0] = newX;
                hider[1] = newY;
            }
        }
        
        // 도망자 턴 종료
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }

    // 술래 움직임
    public static void moveSeeker() {
        // 1. 한 번에 한칸만 움직임 (필수)
        sx += dx[sd];
        sy += dy[sd];

        // 2. 이동 방향 전환 (조건체크)
        if (sx == 0 && sy == 0) {
            sd = 2;
        } else if (sx == n/2 && sy == n/2) {
            sd = 0;
        } else if (needChange(sx, sy)) {
            sd = (sd + 1) % 4;
        }
    }

    // 술래 방향전환 조건 체크
    public static boolean needChange(int x, int y) {
        if (y == n - 1 - x) {
            return true;
        } else if (y >= n/2 && y == x) {
            return true;
        } else if (y <= n/2 && y == x + 1) {
            return true;
        }
        return false;
    }

    // 도망자 잡기
    public static int catchHider() {
        // 격자 내 도망자 수 
        int[][] hiderGrid = new int[n][n];
        for (int i = 0; i < m; i++) {
            int[] h = hiders[i];
            hiderGrid[h[0]][h[1]]++;
        }


        int score = 0;
        // 술래가 바라보는 방향으로 3칸 시야(현재칸 포함)
        for (int i = 0; i < 3; i++) {
            int checkX = sx + (dx[sd] * i);
            int checkY = sy + (dy[sd] * i);

            // 격자 내부인가? 
            if (!inRange(checkX, checkY)) continue;

            // 나무와 함께있으면 못잡음
            if (trees[checkX][checkY]) continue;

            // 숨은 숫자만큼 점수 얻기
            score += hiderGrid[checkX][checkY];
        }

        return score;
    }



    // 하나의 턴 실행
    public static int play1turn() {
        // 1. 도망자 움직임
        moveHider();

        // 2. 술래 움직임
        moveSeeker();

        // 3. 술래가 도망자 잡기
        return catchHider();
    }
}

