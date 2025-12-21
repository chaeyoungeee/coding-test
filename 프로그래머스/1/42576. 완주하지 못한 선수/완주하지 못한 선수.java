import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {        
        HashMap<String, Integer> s = new HashMap<>();
        
        for (String p : participant) {
            s.put(p, s.getOrDefault(p, 0)+1);
        }
        
        for (String c : completion) {
            if (!s.containsKey(c)) return c; 
            s.put(c, s.get(c)-1);
        }
        
        for (String k : s.keySet()) {
            if (s.get(k) != 0) return k;
        }
        
        return "";
    }
}