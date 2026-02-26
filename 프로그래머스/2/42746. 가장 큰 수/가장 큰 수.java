import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        int s = Arrays.stream(numbers).sum();
        if (s == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.stream(numbers).boxed()
            .map(String::valueOf)
            .sorted((a, b) -> (b+a).compareTo(a+b))
            .forEach(n -> {
                sb.append(n);
            });
        
        
        return sb.toString();
    }
}