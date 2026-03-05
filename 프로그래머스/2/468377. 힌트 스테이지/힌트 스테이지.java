import java.util.*;

class Solution {
    static Set<String> create(int n) {
        ArrayDeque<String> dq = new ArrayDeque<>();
        dq.add("0");
        dq.add("1");
        while (!dq.isEmpty()) {
            if (dq.peek().length() == n) break;
            String curr = dq.poll();
            dq.add(curr+"0");
            dq.add(curr+"1");
        }
        return new HashSet<>(dq);
    }
    
    public int solution(int[][] cost, int[][] hint) {
        int n = hint.length;
        Set<String> set = create(n);
        int result = Integer.MAX_VALUE;
        
        for (String s : set) {
            Map<Integer, Integer> map = new HashMap<>();
            int price = cost[0][0];
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    price+=hint[i][0];
                    for (int j = 1; j < hint[i].length; j++) {
                        map.merge(hint[i][j]-1, 1, Integer::sum);
                    }
                }
            }
            
            for (int i = 1; i < cost.length; i++) {
                price += cost[i][Math.min(map.getOrDefault(i, 0), cost[0].length-1)];
            }
            result = Math.min(result, price);   
        }
        return result;
    }
}