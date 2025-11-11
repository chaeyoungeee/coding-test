import java.util.*;

class Solution {
    public long solution(long n) {
        String[] s = String.valueOf(n).split("");
        Arrays.sort(s, Collections.reverseOrder());
        return Long.parseLong(String.join("", s));
    }
}