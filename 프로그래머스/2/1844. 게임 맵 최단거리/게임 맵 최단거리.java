import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] maps) {
        ArrayDeque<int []> dq = new ArrayDeque<>();
        dq.add(new int[] {0, 0});
        int n = maps.length, m = maps[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[][] cost = new int[n][m];
        cost[0][0] = 1;
        
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int[] d : dir) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                
                maps[nx][ny] = 0;
                cost[nx][ny] = cost[curr[0]][curr[1]] + 1;
                dq.add(new int[] {nx, ny});
            }
        }
        
        return cost[n-1][m-1] == 0 ? -1 : cost[n-1][m-1];
    }
}