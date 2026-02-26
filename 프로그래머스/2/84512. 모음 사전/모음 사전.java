import java.util.*;

class Solution {

    static char[] ap = {'A', 'E', 'I', 'O', 'U'};
    static List<String> wlist = new ArrayList<>();
    
    public void perm (int depth, int r, String result) {
        if (depth == r) {
            wlist.add(result);
            return;
        }
        for (int i = 0; i < 5; i++) {
            perm(depth+1, r, result + ap[i]);
        }
    }
    
    public int solution(String word) {
        List<String> data = new ArrayList<>();

    
        for (int i = 1; i < 6; i++) {
            perm(0, i, "");
        }
        
        Collections.sort(wlist);
        
        return wlist.indexOf(word)+1;
    }
}