import java.util.Arrays;
import java.util.stream.*;

class Solution {
    
    static int[] parent;
    
    static int find(int x) { // 부모 값 반환
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    static boolean union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        
        if (r1 == r2) return false;
        if (r1 < r2) parent[r2] = r1;
        else parent[r1] = r2;
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int cost = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        for (int[] c : costs) {
            if (union(c[0], c[1])) cost += c[2];
        }
        return cost;
    }
}