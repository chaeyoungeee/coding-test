import java.util.*;

class Solution {
    int solution(int[][] land) {   
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int m = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    m = Math.max(m, land[i][j] + land[i-1][k]);
                }
                land[i][j] = m;
            }
        }       
        
        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}