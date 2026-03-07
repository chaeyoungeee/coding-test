import java.util.*;

class Solution {

    static int bfs(int[] numbers, int target) {
        int cnt = 0;
            
        int n = numbers.length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {0, numbers[0]});
        q.add(new int[] {0, -numbers[0]});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == n-1) {
                if (now[1] == target) cnt++;
                continue;
            }
            q.add(new int[] {now[0]+1, now[1]+numbers[now[0]+1]});
            q.add(new int[] {now[0]+1, now[1]-numbers[now[0]+1]});
        }
        
        return cnt;
    }
    
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }
}