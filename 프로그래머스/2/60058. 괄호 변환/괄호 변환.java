import java.util.*;

class Solution {
    public String transform(String s) {
        String answer = "";
        // 1
        if (s.equals("")) return "";
        
        // 2
        int a = 0, b = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') a++;
            else b++;
            if (a == b) break;
        }
        String u = s.substring(0, i+1);
        String v = s.substring(i+1, s.length());
        
        // System.out.printf("%s %s\n", u, v);
        // 3
        ArrayDeque<Character> dq = new ArrayDeque<>();
        boolean c = true; // 올바른 문자열인지
        for (int j = 0; j < u.length(); j++) {
            if (u.charAt(j) == '(') {
                dq.add(u.charAt(j));
            } else {
                if (dq.isEmpty() || dq.peekLast() == ')') {
                    c = false;
                    break;
                }
                dq.pollLast();
            }
        }
        if (!dq.isEmpty()) c = false;
        if (c == true) {
            return u + transform(v);
        } else {
            // 4
            StringBuilder nu = new StringBuilder();
            for (int j = 1; j < u.length()-1; j++) {
                if (u.charAt(j) == '(') {
                    nu.append(')');
                } else {
                    nu.append('(');
                }
            }
            return '(' + transform(v) + ')' + nu.toString();
        }
    }
    
    public String solution(String p) {
        return transform(p);
    }
}