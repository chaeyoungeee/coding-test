class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1, next = stations[0]-w-1;
        
        for (int i = 0; i < stations.length + 1; i++) {
            
            answer += Math.max(0, (next-prev+1+2*w) / (2*w+1));
            if (i == stations.length) break;
            prev = stations[i]+w+1;
            next = (i == stations.length-1) ? n : stations[i+1]-w-1;
        }

        return answer;
    }
}