import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int t : tangerine) {
            cnt.put(t, cnt.getOrDefault(t, 0)+1);
        }
        
        List<Integer> values = new ArrayList<>(cnt.values());
        values.sort(Collections.reverseOrder());
        
        for (int v : values) {
            k -= v;
            result += 1;
            if (k <= 0) break;
        }
        
        return result;
    }
}