import java.util.Arrays;

class Solution {
    int getMax(int[] money) {
        int n = money.length;
        int a = money[0];
        int b = Math.max(money[0], money[1]);
                
        for (int i = 2; i < n; i++) {
            int c = b;
            b = Math.max(b, a+money[i]);
            a = c;
        }
    
        return Math.max(a, b);
    }
    
    public int solution(int[] money) {
        int a = getMax(Arrays.copyOfRange(money, 0, money.length-1));
        int b = getMax(Arrays.copyOfRange(money, 1, money.length));
     
        return Math.max(a, b);
    }
}