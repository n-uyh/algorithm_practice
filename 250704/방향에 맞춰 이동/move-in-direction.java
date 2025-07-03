import java.util.Scanner;
public class Main {
    // 동, 서, 남, 북 순서
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static String direction = "EWSN";
    static int x = 0, y = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    

        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();
            move(direction, distance);
        }

        System.out.println(x + " " + y);
    }

    // char to direction index
    public static int getDirection(char d) {
        return direction.indexOf(d);
    }

    public static void move(char direction, int distance) {
        int d = getDirection(direction);
        if (d > -1) {
            x += (dx[d] * distance);
            y += (dy[d] * distance);
        }
    }
}