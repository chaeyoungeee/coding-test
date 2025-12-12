import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] n = new int[N+2];
        Map<Integer, Double> fails = new HashMap<>();
        double l = stages.length;
        
        
        for (int i = 0; i < stages.length; i++) {
            n[stages[i]] += 1;
        }
        
        for (int i = 1; i < N + 1; i++) {
            if (n[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, n[i]/l);
                l -= n[i];   
            }
        }
        
        return fails.entrySet().stream().sorted(
            (o1, o2) ->
                o1.getValue().equals(o2.getValue()) ?
                    Integer.compare(o1.getKey(), o2.getKey()) :
                    Double.compare(o2.getValue(), o1.getValue())
        ).mapToInt(HashMap.Entry::getKey).toArray();
    }
}