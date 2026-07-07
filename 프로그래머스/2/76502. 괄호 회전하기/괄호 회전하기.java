import java.util.Stack;

class Solution {
    
    public boolean complete(String s) {
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') st.add(c);
            else {
                if (st.isEmpty()) return false;
                if (c == ']' && st.pop() != '[') return false;
                if (c == ')' && st.pop() != '(') return false;
                if (c == '}' && st.pop() != '{') return false;
            }
        }
        return st.isEmpty();
    }
    
    public int solution(String s) {
        int answer = 0;
        int i = 0;
        int l = s.length();
        boolean isComplete = false;
        String c = s;
        
        while (i < l) {
            c = s.substring(i, l) + s.substring(0, i);
            if (complete(c)) {
                isComplete = true;
                answer += 1;
            }
            
            if (isComplete) i += 2;
            else i+=1;
        }
        
        return answer;
    }
}