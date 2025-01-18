import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lo = 0;
        int hi = N - 1;

        int resLo = lo, resHi = hi;
        while (lo < hi) {
            int res = arr[lo] + arr[hi];
            int resAbs = Math.abs(res);

            if (Math.abs(arr[resLo] + arr[resHi]) > resAbs) {
                resLo = lo;
                resHi = hi;
            }
            if (res > 0) {
                hi--;
            } else if (res == 0) {
                break;
            } else {
                lo++;
            }
        }

        sb.append(arr[resLo]).append(' ').append(arr[resHi]);
        System.out.println(sb);

    }

}
