import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        List<String[]> result = new ArrayList<>();
        
        for (String r : record) {
            String[] t = r.split(" ");
            if (!t[0].equals("Leave")) nickname.put(t[1], t[2]);
            if (!t[0].equals("Change")) result.add(new String[] {t[0], t[1]});
        }
        
        return result.stream()
            .map(a -> a[0].equals("Enter") ? 
                        nickname.get(a[1]) + "님이 들어왔습니다." 
                        : nickname.get(a[1]) + "님이 나갔습니다.")
            .toArray(String[]::new);
    }
}