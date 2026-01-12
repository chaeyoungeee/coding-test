import java.util.Arrays;

class Solution {
    
    static int[] parents;
        
    static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if (px < py) parents[py] = px;
        else parents[px] = py;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parents = new int[n];
        
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) union(i, j);
            }
        }
        
        System.out.println(Arrays.toString(parents));
        
        return (int) Arrays.stream(parents)
            .map(i -> find(i))
            .distinct()
            .count();
    }
}