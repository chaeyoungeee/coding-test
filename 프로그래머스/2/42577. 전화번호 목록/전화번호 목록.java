import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
            String prev = phone_book[i-1];
            String curr = phone_book[i];
            if (curr.substring(0, Math.min(curr.length(), prev.length())).equals(prev)) {
                return false;
            }
        }
        return true;
    }
}