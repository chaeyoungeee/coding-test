import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        HashMap<String, String> m = new HashMap<>();
        
        for (String r : record) {
            String[] s = r.split(" ");
            
            if (!s[0].equals("Leave")) {
                m.put(s[1], s[2]);
            }
        }
        
        for (String r : record) {
            String[] s = r.split(" ");
            
            if (s[0].equals("Enter")) {
                result.add(m.get(s[1]).concat("님이 들어왔습니다."));
            } else if (s[0].equals("Leave")) {
                result.add(m.get(s[1]).concat("님이 나갔습니다."));
            }
        }
        
        return result.toArray(new String[0]);
    }
}