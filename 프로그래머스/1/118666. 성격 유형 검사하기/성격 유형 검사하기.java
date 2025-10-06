import java.lang.Math;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        Map<Character, Integer> c = new HashMap<>();
        char type;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] < 4) {
                type = survey[i].charAt(0);
            } else if (choices[i] > 4) {
                type = survey[i].charAt(1);
            } else continue;
        
            c.put(type, c.getOrDefault(type, 0) + Math.abs(choices[i]-4));
        }
        
        for (char[] t : types) {
            int s1 = c.getOrDefault(t[0], 0); 
            int s2 = c.getOrDefault(t[1], 0);
            if (s1 > s2) sb.append(t[0]); 
            else if (s1 < s2) sb.append(t[1]);
            else sb.append((char) Math.min(t[0], t[1]));
        } 
            
        return sb.toString();
    }
}