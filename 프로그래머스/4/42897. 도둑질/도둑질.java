import java.util.Arrays;

class Solution {
    int getMax(int[] money) {
        int n = money.length;
        int[] dp = new int[n];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
                
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
        }
    
        return Math.max(dp[n-1], dp[n-2]);
    }
    
    public int solution(int[] money) {
        int a = getMax(Arrays.copyOfRange(money, 0, money.length-1));
        int b = getMax(Arrays.copyOfRange(money, 1, money.length));
     
        return Math.max(a, b);
    }
}