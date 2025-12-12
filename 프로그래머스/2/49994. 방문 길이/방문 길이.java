import java.util.*;

class Solution {
    static Map<Character, int[]> dir = Map.of(
        'U', new int[]{0, 1},
        'D', new int[]{0, -1},
        'R', new int[]{1, 0},
        'L', new int[]{-1, 0}
    );
    static class Path {
        int x1, y1, x2, y2; 
        
        public Path (int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path)) return false;
            Path p = (Path) o;
            return x1 == p.x1 && y1 == p.y1 && x2 == p.x2 && y2 == p.y2;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
    
    public int solution(String dirs) {
        int answer = 0;
        Set<Path> paths = new HashSet<>();
        int cx = 0;
        int cy = 0;
        
        for (char i : dirs.toCharArray()) {
            int[] d = dir.get(i);
            int nx = cx + d[0];
            int ny = cy + d[1];
            if (nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;
            paths.add(new Path(cx, cy, nx, ny));
            paths.add(new Path(nx, ny, cx, cy));
            cx = nx;
            cy = ny;
        }
        
        return paths.size() / 2;
    }
}