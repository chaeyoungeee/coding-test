import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int a, b;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = -1;

    static public void dfs(int x, int y, int cnt) {
        if (x == y) {
            count = cnt;
            return;
        }
        for (int g : graph[x]) {
            if (visited[g]) continue;
            visited[g] = true;
            dfs(g, y, cnt+1);
            visited[g] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new boolean[n+1];
        visited[a] = true;
        dfs(a, b, 0);
        System.out.println(count);
    }
}