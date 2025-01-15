import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] points = new long[N];
        for (int i = 0; i < N; i++) {
            points[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(points);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long l1 = Long.parseLong(st.nextToken());
            long l2 = Long.parseLong(st.nextToken());

            int begin = upper(points, l1);
            int end = lower(points, l2);

            sb.append(end - begin).append("\n");
        }

        System.out.print(sb);
    }

    public static int upper(long[] arr, long target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                begin = mid+1;
            }
        }

        return begin;
    }

    public static int lower(long[] arr, long target) {
        int begin = 0;
        int end = arr.length;

        while (begin < end) {
            int mid = (begin + end) / 2;

            if (arr[mid] <= target) {
                begin = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}