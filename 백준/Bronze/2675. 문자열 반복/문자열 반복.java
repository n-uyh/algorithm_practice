import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();
            for (char c :chars){
                for (int i=0;i<r;i++) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}