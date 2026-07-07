import java.util.*;

class Solution {
    
    static String concat(int a, int b, int c, int d) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);  
        sb.append(c);
        sb.append(d);
        return sb.toString();
    }
    
    static Map<Character, int[]> dir = Map.of(
        'U', new int[]{1, 0},
        'D', new int[]{-1, 0},
        'R', new int[]{0, 1},
        'L', new int[]{0, -1}
    );
    
    public int solution(String dirs) {
        Set<String> s = new HashSet<>();
        int cx = 0, cy = 0;
        int nx, ny;
        
        for (char i :  dirs.toCharArray()) {
            int[] d = dir.get(i);
            nx = cx + d[0];
            ny = cy + d[1];
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            s.add(concat(cx, cy, nx, ny));
            s.add(concat(nx, ny, cx, cy));
            cx = nx;
            cy = ny;
        }

        return s.size() / 2;
    }
}