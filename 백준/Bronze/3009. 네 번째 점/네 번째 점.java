import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 축에 평행한 직사각형 > 내각이 전부 90도 > 각점들의 x좌표를 중복을 제거하면 두개씩일듯?
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();
        
        int round = 3;
        while (round > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (xSet.contains(x)) {
                xSet.remove(x);
            } else {
                xSet.add(x);
            }
            
            if (ySet.contains(y)) {
                ySet.remove(y);
            } else {
                ySet.add(y);
            }
            round--;
        }
        
        String result = xSet.iterator().next() + " " + ySet.iterator().next();
        System.out.print(result);
    }
}