import java.util.*;

class Solution {
    
    static int[][] cost;
    
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
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0) return false;
        if (board[x][y] == 1) return false;
        return true;
    }
    
    static int bfs(int[][] board) {
        int result = Integer.MAX_VALUE;
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
                
                if (cost[board.length-1][board[0].length-1] < Integer.MAX_VALUE) {
                    result = Math.min(result, cost[board.length-1][board[0].length-1]);
                }
            }
        }
        
        return result;
    }
    
    public int solution(int[][] board) {
        
        cost = new int[board.length][board[0].length];
        
        for (int[] c : cost) {
            Arrays.fill(c, Integer.MAX_VALUE-100);
        }
        
        int result = bfs(board);
        return result * 100;
    }
}