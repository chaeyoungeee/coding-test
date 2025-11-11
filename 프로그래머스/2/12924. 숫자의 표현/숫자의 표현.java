class Solution {
    public int solution(int n) {
        int result = 1;
        for (int i = 1; i < n / 2 + 1; i++) {
            for (int j = i + 1; j < n / 2 + 2; j++) {
                int sum = (j-i+1)*(i+j)/2;
                if (sum == n) {
                    result+=1;
                    break;
                }
                if (sum > n) break;
            }
        }
        return result;
    }
}