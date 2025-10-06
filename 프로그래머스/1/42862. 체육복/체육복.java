import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {        
        Set<Integer> r = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> l = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> ol = new HashSet<>(r);
        ol.retainAll(l);
        r.removeAll(ol);
        l.removeAll(ol);
        
        int[] o = {-1, 1};
        int answer = n - l.size();
        lost = l.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        for (int ls : lost) {
            for (int i : o) {
                if (r.contains(ls+i)) {
                    r.remove(ls+i);
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}


