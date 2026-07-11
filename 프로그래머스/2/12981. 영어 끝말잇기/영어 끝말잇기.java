import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0, 0};
        Set<String> s = new HashSet<>();
        s.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (s.contains(words[i]) || 
                words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer[0] = (i+1)%n == 0 ? n : (i+1)%n; // 번호
                answer[1] = (i/n)+1; // 차례
                break;
            }
            s.add(words[i]);
        }

        return answer;
    }
}