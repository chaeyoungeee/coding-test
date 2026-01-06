import java.util.Arrays;

class Solution {
    static int find(int[] array, int[] command) {
        int[] sub = Arrays.copyOfRange(array, command[0]-1, command[1]);
        Arrays.sort(sub);
        return sub[command[2]-1];
    }
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = find(array, commands[i]);
        }
        return answer;
    }
}