class Solution {
    
    public int solution(int[] citations) {
        int n = citations.length;
        int[] count = new int[10001];
        int max = 0;

        for (int i = 0; i < n; i++) {
            count[citations[i]] += 1;
            max = Math.max(citations[i], max);
        }

                
        for (int i = max; i > 0; i--) {
            if (count[i] >= i) return i;
            count[i-1] += count[i];
        }
        
        return 0;
    } 
}