import java.util.*;

class Solution {
    static List<Integer>[] tree;
    
    static int dfs(int x, boolean[] visited) {
        int cnt = 1;
        visited[x] = true;
        for (int i : tree[x]) if (!visited[i]) cnt += dfs(i, visited);
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = n+1;
        tree = new ArrayList[n+1];
    
        for (int i = 0; i < n+1; i++) tree[i] = new ArrayList<>();
        
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            tree[a].add(b); 
            tree[b].add(a);
        }
        
        for (int[] wire: wires) {
            boolean[] visited = new boolean[n+1];
            int a = wire[0], b = wire[1];
            visited[b] = true;
            answer = Math.min(Math.abs(n-2*dfs(a, visited)), answer);
            if (answer == 0) break;
        }
    
        return answer;
    }
}