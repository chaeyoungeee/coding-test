import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int[] c = commands[i];
            int[] temp = Arrays.copyOfRange(array, c[0]-1, c[1]);
            Arrays.sort(temp);
            int v = temp[c[2]-1];
            answer[i] = v;
        }
        return answer;
    }
}