class Solution {
    boolean solution(String s) {
        int c1 = 0, c2 = 0;
        
        for (char i : s.toCharArray()) {
            if (i == 'p' || i == 'P') c1 += 1;
            else if (i == 'y' || i == 'Y') c2 += 1;
        }

        return c1 == c2;
    }
}