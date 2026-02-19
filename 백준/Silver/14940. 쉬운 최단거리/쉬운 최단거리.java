import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] dist;
    static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int n, m;
    static class Point {
        int x, y;
        public Point(int x, int y) {this.x = x; this.y = y;}
    }

    private static void bfs(int sx, int sy) {
        ArrayDeque<Point> que = new ArrayDeque<>();
        que.add(new Point(sx, sy));
        dist[sx][sy] = 0;

        while (!que.isEmpty()) {
            Point curr = que.poll();
            for (int[] dir : dirs) {
                int nx = curr.x + dir[0];
                int ny = curr.y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0) continue;
                if (nx == sx && ny == sy) continue;
                if (dist[nx][ny] > 0) continue;
                // System.out.printf("%d %d\n", nx, ny);
                dist[nx][ny] = dist[curr.x][curr.y] + 1;
                que.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int sx = 0, sy = 0;

        map = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                } 
                // else if (map[i][j] == 1) dist[i][j] = -1;
            }
        }

        bfs(sx, sy);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == 0 && map[i][j] == 1) {
                    bw.write(String.format("%d ", -1));
                } else {
                    bw.write(String.format("%d ", dist[i][j]));    
                }
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }

 
}