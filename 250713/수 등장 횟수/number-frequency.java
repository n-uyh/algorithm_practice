import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int count = map.getOrDefault(number,0);
            map.put(number, count+1);
        }

        for (int i = 0; i < m; i++) {
            System.out.print(map.getOrDefault(sc.nextInt(),0)+" ");
        }
    }
}