import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < n; j++) {
                int s = 0;
                for (int k = j; k < j+i; k++) {
                    if (k >= n) s += elements[k % n];
                    else s += elements[k];
                }
                set.add(s);
            }
        }
        
        return set.size();
    }
}