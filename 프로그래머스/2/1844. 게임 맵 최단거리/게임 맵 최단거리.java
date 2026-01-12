import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    
    static int n, m;
    static int[][] visited;
    static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
    
    static void bfs(int[][] maps) {
        visited[0][0] = 1;
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0, 0});
        
        while(!que.isEmpty()) {
            int[] c = que.poll();
            for (int[] dir : dirs) {
                int nx = c[0] + dir[0];
                int ny = c[1] + dir[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || 
                    visited[nx][ny] != 0 || maps[nx][ny] == 0) continue;
                
                que.add(new int[] {nx, ny});
                visited[nx][ny] = visited[c[0]][c[1]] + 1;
                
                if (nx == (n-1) && ny == (m-1)) return;
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        
        bfs(maps);
        
        return visited[n-1][m-1] == 0 ? -1 : visited[n-1][m-1];
    }
}