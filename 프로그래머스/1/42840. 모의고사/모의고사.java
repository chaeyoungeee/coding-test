import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] s = {{ 1, 2, 3, 4, 5 },
                      { 2, 1, 2, 3, 2, 4, 2, 5 },
                      { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }};
        int[] c = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (s[j][i % s[j].length] == answers[i]) c[j]++;
            }
        }
        
        List<Integer> a = new ArrayList<>();
        
        int m = Arrays.stream(c).max().getAsInt();
        for (int i = 0; i < 3; i++) {
            if (c[i] == m) a.add(i+1);
        }
    
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
}