import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> t = new HashMap<>();
        int[] d1 = Arrays.stream(today.split("\\."))
            .mapToInt(Integer::parseInt)
            .toArray(); // 년, 월, 일
        
        for (String term : terms) {
            String[] s = term.split(" ");
            t.put(s[0], Integer.valueOf(s[1]));
        }
        
        int i = 0;
        for (String privacy : privacies) {
            i++;
            String[] s = privacy.split(" ");
            int[] d2 = Arrays.stream(s[0].split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
            
            int tt = t.get(s[1]);
            d2[1] += tt;
            if (d2[2] == 1) {
                d2[1] -= 1;
                d2[2] = 28;
            } else {
                d2[2] -= 1;
            }
            d2[0] += d2[1] / 12;
            d2[1] = d2[1] % 12;
            if (d2[1] ==0) {
                d2[1] = 12;
                d2[0] -=1;
            }
            
            System.out.println(Arrays.toString(d1));
                        System.out.println(Arrays.toString(d2));
            if (d1[0] < d2[0]) {
                continue;
            } else if (d1[0] == d2[0]) {
                if (d1[1] < d2[1]) {
                    continue;
                } else if (d1[1] == d2[1]) {
                    if (d1[2] <= d2[2]) continue;
                    answer.add(i);
                } else {
                    answer.add(i);
                    continue;
                }
            } else {
                answer.add(i);
                continue;
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}