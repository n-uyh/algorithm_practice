import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int K = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensors = new int[N];
        for (int i = 0; i < N; i++) {
            sensors[i] = parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        int[] distances = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(distances);

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += distances[i];
        }
        System.out.println(sum);
    }

}
