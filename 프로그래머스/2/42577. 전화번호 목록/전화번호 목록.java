import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        boolean answer = true;
        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].substring(0, Math.min(phone_book[i-1].length(), phone_book[i].length()))
                .equals(phone_book[i-1])) {
                answer = false;
                break;
            }
        }
        return answer;
    }
}