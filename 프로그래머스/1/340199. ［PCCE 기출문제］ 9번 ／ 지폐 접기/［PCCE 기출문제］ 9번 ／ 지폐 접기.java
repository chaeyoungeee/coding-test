import java.util.Arrays;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        int count = 0;
        
        while(true) {
            Arrays.sort(bill);
            if (bill[0] <= wallet[0] && bill[1] <= wallet[1]) break;
            bill[1] /= 2;
            count += 1;
        }

        return count;
    }
}