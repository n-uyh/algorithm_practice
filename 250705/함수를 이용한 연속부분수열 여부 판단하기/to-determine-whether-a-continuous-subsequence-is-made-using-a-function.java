import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        // a 초기화
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        // b 초기화
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();

        // 수열 A를 순회하면서 B의 원소와 일치하는지 순서대로 찾기
        boolean result = false;
        for (int i = 0; i < n1; i++) {
            result = checkB(a,b,i,0);
            if (result) break;
        }
        
        System.out.println(result ? "Yes":"No");
    }

    public static boolean checkB(int[] a, int[] b, int aIndex, int bIndex) {
        if (a[aIndex] == b[bIndex]) {
            return bIndex == b.length - 1 || (aIndex+1 < a.length && checkB(a, b, aIndex+1, bIndex+1));
        }
        return false;
    }

    
}