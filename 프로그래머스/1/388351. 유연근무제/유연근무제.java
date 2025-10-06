class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int cnt = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            int p = 0;
  
            int m = schedules[i] + 10;
            if (m % 100 >= 60) m += 40;
            
            for (int j = 0; j < 7; j++) {
                int d = (j+startday) % 7;
                if (d == 6 || d == 0) continue;
                if (timelogs[i][j] > m) break;
                p++;
            }
            
            if (p == 5) cnt++;
        }
        
        return cnt;
    }
}