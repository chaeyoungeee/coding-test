import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> m = new HashMap<>();
        
        for (int t : tangerine) {
            m.merge(t, 1, Integer::sum);
        }
        
        List<Map.Entry<Integer, Integer>> sm = m.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
            .collect(Collectors.toList());
        
        int i = 0;
        for (; i < sm.size(); i++) {
            k -= sm.get(i).getValue();
            if (k <= 0) break;
        }
        
        return i + 1;
    }
}