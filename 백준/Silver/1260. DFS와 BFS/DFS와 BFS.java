import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    // 입력 : n, m, v, loop: a,b
    public static int n, m, v, a, b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        int[][] edges = new int[n + 1][n + 1];
        // 간선의 개수 만큼 반복
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        dfs(edges, v);
        bfs(edges, v);
    }

    static void dfs(int[][] edges, int startV) {
        boolean[] visited = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        stack.push(startV);
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                visited[node] = true;
                sb.append(node).append(' ');

                for (int i = n; i > 0 ; i--) {
                    if (edges[node][i] == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }

        System.out.println(sb);
    }

    static void bfs(int[][] edges, int startV) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startV);
        visited[startV] = true;

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(' ');
            for (int i = 1; i <= n; i++) {
                if (edges[node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        System.out.println(sb);
    }


}
