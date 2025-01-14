import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        arr[0] =  Long.parseLong(br.readLine());
        long max = arr[0];
        for (int i = 1; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max){
                max = arr[i];
            }
        }


        long start = 1;
        long end = max + 1;
        long mid = 0;

        while (start < end) {
            mid = (end + start) / 2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (count >= N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(start - 1);
    }
    

}