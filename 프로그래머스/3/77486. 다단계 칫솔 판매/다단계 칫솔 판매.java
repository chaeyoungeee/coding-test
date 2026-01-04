import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> p = new HashMap<String, String>(); //셀러, 추천인
        Map<String, Integer> prices = new HashMap<String, Integer>();
        
        for (int i = 0; i < enroll.length; i++) {
            p.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int price = amount[i] * 100;
            String s = seller[i];
            while (p.containsKey(s)) {
                if (price < 10) break;
                prices.merge(s, price - (int) (price * 0.1), Integer::sum);
                price = (int) (price * 0.1);
                s = p.get(s);
            }
            prices.merge(s, price, Integer::sum);
        }
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = prices.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
}