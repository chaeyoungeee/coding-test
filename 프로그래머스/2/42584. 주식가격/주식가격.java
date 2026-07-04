import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        Stack<int[]> st = new Stack<>();
        
        for (int i = 0; i < l; i++) {
            int curr = prices[i];
            while (!st.isEmpty() && st.peek()[0] > prices[i]) {
                int t = st.pop()[1];
                answer[t] = i-t;
            }
            st.push(new int[] {prices[i], i});
        }
        
        while (!st.isEmpty()) {
            int t = st.pop()[1];
            answer[t] = l-t-1;
        }
        
        return answer;
    }
}