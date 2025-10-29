class Solution {
    
    int len;
    int target;
    int answer = 0;
    int[] numbers;
    
    public void dfs(int i, int sum) {
        if (i == len) {
            if (sum == target) answer += 1;
            return;
        }
        dfs(i+1, sum+numbers[i]);
        dfs(i+1, sum-numbers[i]);
    }
    
    public int solution(int[] numbers, int target) {
        len = numbers.length;
        this.target = target;
        this.numbers = numbers;
        
        dfs(0, 0);
        return answer;
    }
}