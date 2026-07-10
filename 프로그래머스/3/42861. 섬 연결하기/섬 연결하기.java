import java.util.*;

class Solution {
    
    static int parent[];
    
    static int find(int a) {
        if (a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }
    
    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        
        if (pa == pb) return false;
        else if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
        return true;
    }
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
    
        for (int i = 0; i < costs.length; i++) {
            if (union(costs[i][0], costs[i][1])) answer += costs[i][2];
            int s = Arrays.stream(parent).sum();
            if (s == 0) break;
        }
        
        return answer;
    }
}