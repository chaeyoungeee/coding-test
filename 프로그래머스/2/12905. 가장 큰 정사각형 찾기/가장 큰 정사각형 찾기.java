import java.util.*;

class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int[][] dirs = {{0, -1}, {-1, 0}, {-1, -1}};
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (answer == 0) {
                        answer = Math.max(board[i][j], answer);
                    } 
                    continue;
                }
                if (board[i][j] == 0) continue;
                int m = Integer.MAX_VALUE;
                for (int[] d : dirs) {
                    m = Math.min(m, board[i+d[0]][j+d[1]]);
                }
                board[i][j] = m + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        return answer * answer;
    }
}