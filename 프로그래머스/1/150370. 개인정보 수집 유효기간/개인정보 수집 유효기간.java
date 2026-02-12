import java.util.*;

class Solution {
    public int getDate(String date, int term) {
        int[] d = Arrays.stream(date.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray();
        return d[0] * 12 * 28 + (term + d[1]) * 28 + d[2];
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> t = new HashMap<>();
        int d1 = getDate(today, 0);
        
        for (String term : terms) {
            String[] s = term.split(" ");
            t.put(s[0], Integer.valueOf(s[1]));
        }
        
        int i = 0;
        for (String privacy : privacies) {
            i++;
            String[] s = privacy.split(" ");
            int d2 = getDate(s[0], t.get(s[1]));
            if (d1 >= d2) answer.add(i); 
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}