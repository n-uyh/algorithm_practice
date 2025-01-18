import java.util.Scanner;

public class Main {

    public static int n, m, l ,r, total;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
            l = Math.max(l, arr[i]);
        }

        r = total;
        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > mid) {
                    sum = arr[i];
                    cnt++;
                }
            }
            if (cnt <= m) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

}
