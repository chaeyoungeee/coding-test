import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> m = new HashMap<>();
        for (String[] c : clothes) {
            m.merge(c[1], 1, Integer::sum);
        }
        
        int answer = 1;
        for (Integer v : m.values()) {
            answer *= (v+1);
        }
        return answer-1;
    }
}