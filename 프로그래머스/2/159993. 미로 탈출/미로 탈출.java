import java.util.*;

class Solution {
    
    static int[][] map;
    static int n, m;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    static int bfs(int[] start, int[] end, int[][] visited) {
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(start);
        
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == -1 || visited[nx][ny] != 0) continue;
                
                visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                if (nx == end[0] && ny == end[1]) return visited[nx][ny];
                que.add(new int[] {nx, ny});
            }
        }
        
        return -1;
    }
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char curr = maps[i].charAt(j);
                if (curr == 'S') {
                    start = new int[] {i , j};
                } else if (curr == 'E') {
                    exit = new int[] {i , j};
                } else if (curr == 'L') {
                    lever = new int[] {i , j};
                }
                
                if (curr == 'X') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
                
        int s1 = bfs(start, lever, new int[n][m]);
        if (s1 == -1) return -1;
        
        int s2 = bfs(lever, exit, new int[n][m]);
        if (s2 == -1) return -1;
        
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        
        return s1 + s2;
    }
}