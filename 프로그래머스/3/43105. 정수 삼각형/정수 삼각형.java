class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            int[] now = triangle[i];
            for (int j = 0; j < now.length; j++) {
                int[] prev = triangle[i+1];
                now[j] += Math.max(prev[j], prev[j+1]);
            }
        }
        return triangle[0][0];
    }
}