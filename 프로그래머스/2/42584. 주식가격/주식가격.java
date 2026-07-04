import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int l = prices.length;
        int[] answer = new int[l];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < l; i++) {
            int curr = prices[i];
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int t = st.pop();
                answer[t] = i-t;
            }
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            int t = st.pop();
            answer[t] = l-t-1;
        }
        
        return answer;
    }
}