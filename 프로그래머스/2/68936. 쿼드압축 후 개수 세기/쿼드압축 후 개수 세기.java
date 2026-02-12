import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int k = arr.length;
        int[][] dirs = {{0,0}, {1, 0}, {1, 1}, {0, 1}};
        int[] answer = {0, 0};
        int[][] next = new int[k/2][k/2];
    
    
        while (true) {
            next = new int[k/2][k/2];
            for (int i = 0; i < k-1; i+=2) {
                for (int j = 0; j < k-1; j+=2) {
                    int[] c = {0, 0};
                    for (int[] dir : dirs) {
                        if (arr[i+dir[0]][j+dir[1]] == 0) c[0] += 1;
                        else if (arr[i+dir[0]][j+dir[1]] == 1) c[1] += 1;
                    }
                    if (c[0] == 4) {
                        next[i/2][j/2] = 0;
                    } else if (c[1] == 4) {
                        next[i/2][j/2] = 1;
                    } else {
                        next[i/2][j/2] = -1;
                        answer[0] += c[0];
                        answer[1] += c[1];
                    }
                }
            }
            
            if (k == 2) {
                if (next[0][0] != -1) {
                    answer[next[0][0]] += 1;
                }
                break;
            }

            k /= 2;
            arr = new int[k][k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = next[i].clone();
            }         
        }
        

        return answer;
    }
}