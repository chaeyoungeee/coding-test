import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        for (String r : report) {
            String[] rr = r.split(" ");
            map.computeIfAbsent(rr[1], e -> new HashSet<>()).add(rr[0]);
        }
        
        map.entrySet().forEach(e -> {
                HashSet<String> v = e.getValue();
                if (v.size() >= k) {
                     for (String i : v) {
                        count.merge(i, 1, Integer::sum);
                    }
                }
        });
        
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            result[i] = count.getOrDefault(id_list[i], 0);
        }
        
        return result;
    }
}