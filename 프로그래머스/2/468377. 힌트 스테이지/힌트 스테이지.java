import java.util.*;

class Solution {
    
    public int solution(int[][] cost, int[][] hint) {
        int n = hint.length;
        int result = Integer.MAX_VALUE;
        
        for (int mask = 0; mask < (1 << n); mask++) {
            int[] count = new int[n+1];
            int price = cost[0][0];
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    price += hint[i][0];
                    
                    for (int j = 1; j < hint[i].length; j++) {
                        count[hint[i][j]-1]++;
                    }
                }
            }
            for (int i = 1; i < cost.length; i++) {
                price += cost[i][Math.min(count[i], cost[i].length - 1)];
            }

            result = Math.min(result, price);
        }
        
        return result;
    }
}