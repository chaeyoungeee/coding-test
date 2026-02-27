import java.util.*;
import java.util.stream.*;

class Solution {
    public static class Word {
        int c;
        String s;
        public Word (int c, String s) {this.c = c; this.s = s;}
    }
    
    public static Set<String> find(String s, Set<String> words) {
        Set<String> set = new HashSet<>();
        l:
        for (String w : words) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {    
                if (w.charAt(i) != s.charAt(i)) cnt++;
                if (cnt > 1) continue l;
            }
            if (cnt == 1) set.add(w);
        }
        return set;
    }
    
    public static int bfs(String begin, String target, Set<String> words) {
        ArrayDeque<Word> q = new ArrayDeque<>();
        q.add(new Word(0, begin));
        
        while(!q.isEmpty() || words.size() != 0) {           
            Word curr = q.poll();
            words.remove(curr.s);
            
            Set<String> s = find(curr.s, words);
            if (s.contains(target)) return curr.c + 1;
            for (String i : s) {
                q.add(new Word(curr.c + 1, i));
            }
        }
        return 0;
    }
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, Arrays.stream(words).collect(Collectors.toSet()));
    }
}