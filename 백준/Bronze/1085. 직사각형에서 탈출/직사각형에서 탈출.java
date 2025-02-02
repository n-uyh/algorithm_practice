import java.util.*;
public class Main {
    public static int x, y, w, h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        x = sc.nextInt();
        y = sc.nextInt();
        w = sc.nextInt();
        h = sc.nextInt();
        
        int horizon = Math.min(x, w-x);
        int vertical = Math.min(y, h-y);
        System.out.println(Math.min(horizon, vertical));
    }
}