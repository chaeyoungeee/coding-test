import java.util.Arrays;

class Solution {
    public long solution(long n) {
        char[] ca = String.valueOf(n).toCharArray();
        Arrays.sort(ca);
        StringBuilder sb = new StringBuilder();
        for (int i = ca.length -1; i >= 0; i--) {
            sb.append(ca[i]);
        }
        return Long.valueOf(sb.toString());
    }
}