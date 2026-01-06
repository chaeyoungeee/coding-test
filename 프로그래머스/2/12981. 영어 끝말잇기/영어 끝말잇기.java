import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            if (prev.charAt(prev.length()-1) == words[i].charAt(0)
                && !set.contains(words[i])) {
                set.add(words[i]);
                continue;
            }
            answer[0] = (i + 1) % n;
            answer[1] = (i + n) / n;
            if (answer[0] == 0) answer[0] = n;
            break;
        }

        return answer;
    }
}