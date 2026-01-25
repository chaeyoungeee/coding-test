class Solution {
    public int solution(int n) {
        int a = 1;
        int b = 2;
        for (int i = 3; i < n + 1; i++) {
            int t = b;
            b = (a+b) % 1_000_000_007;
            a = t;
        }
        return b;
    }
}