import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        int[][] record = new int[n][n];
        int[] score = new int[n];
        Map<String, Integer> fmap = new HashMap<>();
        int[] next = new int[n];
        
        for (int i = 0; i < n; i++) fmap.put(friends[i], i);
        
        for (String gift: gifts) {
            String[] names = gift.split(" ");
            int i1 = fmap.get(names[0]);
            int i2 = fmap.get(names[1]);
            record[i1][i2] += 1;
            score[i1] += 1;
            score[i2] -= 1;
        }
        
        
        for (int i = 0; i < n-1; i++) {
            for (int j = i; j < n; j++) {
                if (record[i][j] > record[j][i]) next[i] += 1;
                else if (record[i][j] < record[j][i]) next[j] += 1;
                else {
                    if (score[i] > score[j]) next[i] += 1;
                    else if (score[i] < score[j]) next[j] += 1;
                }
            }
        }
    
        return Arrays.stream(next).max().getAsInt();
    }
}