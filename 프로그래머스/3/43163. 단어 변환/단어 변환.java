import java.util.*;
import java.util.stream.*;

class Solution {
    static class B {
        String word;
        int cnt;
        
        public B(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    static boolean oneDiff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (cnt > 1) return false;
            if (a.charAt(i) != b.charAt(i)) cnt +=1;
        }
        
        if (cnt == 1) return true;
        return false;
    }
    
    public int solution(String begin, String target, String[] words) {
        ArrayDeque<B> d = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        
        d.add(new B(begin, 0));
        visited.add(begin);
        
        while (!d.isEmpty()) {
            B b = d.poll();
            
            if (b.word.equals(target)) {
                return b.cnt;
            }
            
            for (String word : words) {
                if (!visited.contains(word) && oneDiff(word, b.word)) {
                    visited.add(word);
                    d.add(new B(word, b.cnt+1));
                }
            }
            
        }
        
        return 0;
    }
}