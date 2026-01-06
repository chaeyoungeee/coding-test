import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int citation : citations) {
            count.merge(citation, 1, Integer::sum);
        }
        
        List<Integer> keys = count.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        for (int i = 0; i < keys.size(); i++) {
            int k = keys.get(i);
            int v = count.get(k);
            if (k >= v) {
                answer = v;
            }
            if (i != keys.size()-1) {
                count.merge(keys.get(i+1), v, Integer::sum);   
            }
        }
    
        return answer;
    }
}