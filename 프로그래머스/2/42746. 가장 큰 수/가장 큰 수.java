import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        boolean allZero = true;
        for (int number : numbers) {
            if (number != 0) {
                allZero = false;
                break;
            }
        }
        
        if (allZero) {
            return "0";
        }
        
        Arrays.stream(numbers)
            .boxed()
            .map(String::valueOf)
            .sorted((a, b) -> {
                return (b+a).compareTo(a+b);
            })
            .forEach(s -> sb.append(s));
        
        return sb.toString();
    }
}