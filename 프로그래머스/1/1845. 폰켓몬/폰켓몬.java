import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return Math.min(set.size(), (int) nums.length / 2);
    }
}