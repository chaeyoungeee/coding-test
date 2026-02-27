import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        int[][] dirs = {{-1, 0}, {0, -1}};
        int r = 1_000_000_007;
        
        map[0][0] = 1;
        for (int[] p : puddles) map[p[1]-1][p[0]-1] = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) continue;
                for (int[] d : dirs) {
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny] == -1) continue;
                    map[i][j] += map[nx][ny];
                    map[i][j] %= r;
                }
            }
        }
        
        // for (int[] k : map) {
        //         System.out.println(Arrays.toString(k));   
        // }
    
        return map[n-1][m-1] %= r;
    }
}