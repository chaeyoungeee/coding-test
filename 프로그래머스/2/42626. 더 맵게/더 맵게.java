import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s: scoville) {
            pq.add(s);
        }
        
        while (pq.size() >= 2) {
            if (pq.peek() >= K) break;
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + 2 * b);
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}