import java.util.*;

class Solution {
    
    static int[][] cost;
    static int n, m;
    static int max;
    
    static int[][] dirs = {
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };
    
    static class Info {
        int x, y, dir, cost;
        public Info(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    static boolean inBoard(int x, int y, int[][] board) {
        if (x >= n || x < 0 || y >= m || y < 0) return false;
        if (board[x][y] == 1) return false;
        return true;
    }
    
    static int bfs(int[][] board) {
        int result = max;
        ArrayDeque<Info> que = new ArrayDeque<>();
        for (int i = 0; i < 2; i++) {
            cost[0][0] = 0;
            que.add(new Info(0, 0, i, 0));
        }
        
        while (!que.isEmpty()) {
            Info now = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dirs[i][0];
                int ny = now.y + dirs[i][1];
                
                if (!inBoard(nx, ny, board)) continue;
                int ncost = now.cost;
                if (now.dir != i) ncost += 5;
                ncost++;
                
                if (cost[nx][ny] > 0 && cost[nx][ny] + 6 < ncost + 2) continue;
                
                cost[nx][ny] = ncost;
                que.add(new Info(nx, ny, i, ncost));
                
                if (cost[n-1][m-1] < max) {
                    result = Math.min(result, cost[n-1][m-1]);
                }
            }
        }
        
        return result;
    }
    
    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        cost = new int[n][m];
        max = n * m * 6;
        
        for (int[] c : cost) {
            Arrays.fill(c, max);
        }
        
        int result = bfs(board);
        return result * 100;
    }
}