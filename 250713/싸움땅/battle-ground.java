// n*n 격자
// 플레이어 
//     - 초기 능력치
//     - 총
//     - 포인트
//     - 플레이어 번호
//     - 방향
//     - 라운드
//         1.
//         - 반대방향 한칸 이동
//         - 격자 이탈 시 원방향 한칸 이동
//         2. 
//         - 플레이어 ?
//             - X: 총 확인 -> 총 획득(가진 것과 놓인 것 중 더 쎈것/ 안가진건 격자에 back)
//             - O: 싸움. 
//                 - 각 플레이어 초기능력치+총공격력 높이 쪽이 승리. 같다면 초기능력치 높은 쪽이 승리
//                 - 포인트 : (초기능력치+총공격력)의 차이 만큼 포인트 획득
//                 - 진 플레이어: 총 격자위에 둠. 원방향 한칸 이동
//                     - 타 플레이어 혹은 격자 범위 밖인 경우 오른쪽 90도 회전해 빈칸이 보이는 순간 이동.(총 획득)
//                 - 이긴 플레이어: 총들 중 가장 공격력 높은 총 획득, 나머지는 내려놓음

import java.util.*;
import java.io.*;
public class Main {
    static int n, m, k;
    static List<Integer>[][] guns;
    static List<Player> players = new ArrayList<>();

    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 총
        guns = new LinkedList[n][n];
        // 총 격자 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                guns[i][j] = new LinkedList<>();
            }
        }
        // 총 놔두기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int gun_power = Integer.parseInt(st.nextToken());
                guns[i][j].add(gun_power);
            }
        }

        // 플레이어
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            Player p = new Player(i,x,y,d,s);;
            players.add(p);
        }

        // 라운드 반복
        while(k-- > 0) {
            // 플레이어 이동
            for (Player p : players) {
                p.move();

                Optional<Player> rival = players.stream().filter(a -> a.inSameCell(p)).findFirst();
                if (rival.isPresent()) {
                    Player r = rival.get();
                    // 같은칸에 있는 경우
                    if (p.win(r)) {
                        p.addPoint(r);
                        moveLoser(r);
                        p.chooseGun();
                    } else {
                        r.addPoint(p);
                        moveLoser(p);
                        r.chooseGun();
                    }
                } else {
                    // 같은칸에 없는경우 -> 총 선택
                    p.chooseGun();
                }
            }
        }

        // 출력
        for (Player p : players) {
            System.out.print(p.point+" ");
        }  
    }

    static class Player {
        int no;
        int x;
        int y;
        int d;
        int s; // 초기 능력치
        int gun;
        int point;

        public Player(int no,int x, int y , int d, int s) {
            this.no = no;
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
            this.gun = 0;
            this.point = 0;
        }

        public boolean inSameCell(Player another) {
            return this.x == another.x && this.y == another.y && this.no != another.no;
        }

        public void move() {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!inRange(nx,ny)) {
                this.d = (d + 2) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            this.x = nx;
            this.y = ny;
        }

        public int power() {
            return s + gun;
        }
        
        public boolean win(Player another) {
            if (this.power() > another.power()) {
                return true;
            } else if (this.power() == another.power() && this.s > another.s) {
                return true;
            }
            return false;
        }

        public void addPoint(Player another) {
            this.point += this.power() - another.power();
        }

        // 총 선택
        public void chooseGun() {
            if (guns[x][y].size() > 0)  {
                int max_gun = Collections.max(guns[x][y]);
                if (max_gun > this.gun) {
                    int max_index = guns[x][y].indexOf(max_gun);
                    guns[x][y].set(max_index, this.gun);
                    this.gun = max_gun;
                }
            }
        }

        public void dropGun() {
            if (guns[x][y].size() > 0) {
                guns[x][y].add(this.gun);
                this.gun = 0;
            }
        }
    }

    public static void moveLoser(Player loser) {
        // 총 내려놓기
        loser.dropGun();

        // 이동
        for (int i = 0; i < 4; i++) {
            int d = (loser.d + i) % 4;
            int nx = loser.x + dx[d];
            int ny = loser.y + dy[d];

            Optional<Player> another = players.stream().filter(a -> a.x == nx && a.y == ny).findFirst();
            if (!inRange(nx,ny) || another.isPresent()) {
                continue;
            }

            loser.x = nx;
            loser.y = ny;
            loser.d = d;
            break;
        }
        loser.chooseGun();
    }


    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n 
            && 0 <= y && y < n;
    }
}