import java.util.*;

class Solution {
    public int count(int n) {
        int cnt = 0;
        
        String b = Integer.toBinaryString(n);
        char[] bc = b.toCharArray();
        
        for (char c : bc) {
            if (c == '1') {
                cnt += 1;
            }
        }
        
        return cnt;
    }
    
    public int solution(int n) {
        int cnt = count(n);
        
        while(true) {
            int cnt2 = count(++n);
            if (cnt == cnt2) {
                return n;
            }
        }
    }
}