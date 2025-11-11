class Solution {
    public long solution(int a, int b) { 
        if (a == b) return a;
        int s = Math.min(a, b), e = Math.max(a, b);
        return (long) (e-s+1)*(s+e)/2;
    }
}