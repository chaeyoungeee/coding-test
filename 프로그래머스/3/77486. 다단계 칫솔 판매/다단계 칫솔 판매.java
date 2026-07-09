import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> cn = new HashMap<>();
        Map<String, Integer> pf = new HashMap<>();
        pf.put("-", 0);
        
        for (int i = 0; i < enroll.length; i++) {
            cn.put(enroll[i], referral[i]);
            pf.put(enroll[i], 0);
        }
        
        System.out.println(cn);
        
        for (int i = 0; i < seller.length; i++) {
            String curr = seller[i];
            int a = amount[i] * 100;
            while (!curr.equals("-")) {
                if (a >= 10) {
                    pf.merge(curr, a-(int)(a*0.1), Integer::sum);
                    a *= 0.1;
                    curr = cn.get(curr);
                } else {
                    pf.merge(curr, a, Integer::sum);
                    break;
                }
            }
        }
        
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = pf.get(enroll[i]);
        }
        
        return answer;
    }
}