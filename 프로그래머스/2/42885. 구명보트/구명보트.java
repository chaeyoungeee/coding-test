import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        
        while (i <= j) {
            count+=1;
            if (i == j) break;
            if (people[i] + people[j] <= limit) i+=1;
            j-=1;
        }
        
        return count;
    }
}