import java.util.*;

class Solution {
    static int[][] rate = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    
    int caculate(int idx, int[] c) {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            s += c[i] * rate[idx][i];
        }
        return s;
    }
    public int solution(int[] picks, String[] minerals) {
        int n = Math.min(Arrays.stream(picks).sum() * 5, minerals.length);
        List<int []> cnt = new ArrayList<>();
        int result = 0;
        
        for (int i = 0; i < n; i+=5) {
            int[] c = new int[3];
            for (int j = i; j < Math.min(i+5, n); j++) {
                if (minerals[j].equals("diamond")) c[0] += 1;
                else if (minerals[j].equals("iron")) c[1] += 1;
                else c[2] += 1;   
            }
            cnt.add(c);
        }
        
        cnt.sort((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) return Integer.compare(b[2], a[2]);
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        for (int[] c : cnt) {
            for (int i = 0; i < 3; i++) {
                if (picks[i] == 0) continue;
                picks[i] -= 1;
                result += caculate(i, c);
                break;
            }
        }
        
        return result;
    }
}