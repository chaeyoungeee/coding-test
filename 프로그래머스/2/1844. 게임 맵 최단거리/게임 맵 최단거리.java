import java.util.*;

class Solution {
    
    int n;
    int m;
    int[][] visited;
    int[][] maps;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    
    public void bfs(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = 1;
        while(!queue.isEmpty()) {
            int [] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];   
    
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny] != -1) continue;
                
                queue.add(new int[] {nx, ny});
                visited[nx][ny] = visited[poll[0]][poll[1]] + 1;
                
                if (nx == n-1 && ny == m-1) return;
            }
        }
    }
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = -1;
            }
        }
        bfs(0, 0);
        return visited[n-1][m-1];
    }
}