import java.util.*;
import java.util.stream.*;

class Solution {

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<Integer>> m = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];
            
            sum.merge(g, p, Integer::sum);
            m.computeIfAbsent(g, k -> new ArrayList<>()).add(i);
        }
        
        List<String> s = sum.entrySet().stream()
            .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        
        List<Integer> result = new ArrayList<>();
        
        for (String i : s) {
            List<Integer> l = m.get(i);
            l.sort(Comparator.<Integer>comparingInt(e -> plays[e]).reversed()
                       .thenComparingInt(e -> e));
            
            
            for (int j = 0; j < Math.min(2, l.size()); j++) {
                result.add(l.get(j));   
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}