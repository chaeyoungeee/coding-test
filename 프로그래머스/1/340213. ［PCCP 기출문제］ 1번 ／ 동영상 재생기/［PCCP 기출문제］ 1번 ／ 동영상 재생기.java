import java.util.*;

class Solution {
    static String video_len;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        this.video_len = video_len;
        pos = opening(pos, op_start, op_end);
        
        for (String command : commands) {
            pos = operation(command, pos);
            pos = opening(pos, op_start, op_end);
        }
        
        return pos;
    }
    
    public String opening(String pos, String op_start, String op_end) {
        if (pos.compareTo(op_start) >= 0 && pos.compareTo(op_end) <= 0) return op_end;
        else return pos;
    }
    
    public String operation(String command, String pos) {
        String[] time = pos.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        
        if (command.equals("prev")) {
            m -= 10;
        } else if (command.equals("next")) {
            m += 10;
        }
        
        if (m >= 60) {
            h += m / 60;
            m %= 60;
        } else if (m < 0) {
            h -= 1;
            m += 60;
        }
        
        if (h < 0) {
            return "00:00";
        }
        
        String f = "%02d:%02d";
        
        if (String.format(f, h, m).compareTo(video_len) > 0) return video_len;
        
        return String.format(f, h, m);
    }
    
}