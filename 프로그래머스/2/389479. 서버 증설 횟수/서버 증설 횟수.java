import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        int n = 0;
        Map<Integer, Integer> servers = new HashMap<>();
        for (int i=0; i < players.length; i++) {
            int left = players[i]-(m*n);
            if (left > 0) {
                int sn = (int) left / m;
                n += sn;
                result += sn;
                servers.put(i+k-1, servers.getOrDefault(i+k-1, 0)+sn);
            }
            if (servers.containsKey(i)) {
                n -= servers.get(i);
                servers.remove(i);
            }
        }
        
        return result;
    }
}