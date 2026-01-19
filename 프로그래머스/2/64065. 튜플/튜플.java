import java.util.*;

class Solution {
    public int[] solution(String s) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        
        s = s.replace("},{", "-")
            .replaceAll("[{}]", "");
        
        String[] arr = s.split("-");
        Arrays.stream(arr)
            .sorted(Comparator.comparing(String::length))
            .forEach(a -> {
                String[] sarr = a.split(",");
                for (String sa : sarr) {
                    int k = Integer.parseInt(sa);
                    if (!set.contains(k)) {
                        set.add(k);
                        answer.add(k);
                        break;
                    }
                }
            });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}