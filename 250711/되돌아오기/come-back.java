import java.util.Scanner;
public class Main {
    static int n;
    // 동서남북
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static String direction = "EWSN";
    static int x = 0, y = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // n번 이동
        int time = 0;
        A : for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int d = direction.indexOf(dir);

            // 이동거리만큼 시간이 흐름
            for (int j = 1; j <= dist; j++) {
                time++;
                x = x + dx[d];
                y = y + dy[d];

                if (isStart()) break A;
            }
        }

        if (!isStart()) {
            System.out.print(-1);
        } else {
            System.out.print(time);
        }
    }

    public static boolean isStart() {
        return x == 0 && y == 0;
    }
}