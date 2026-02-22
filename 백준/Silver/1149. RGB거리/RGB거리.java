import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n][3];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] prev = new int[3];
        int[] curr = new int[3];

        for (int i = 0; i < 3; i++) {
            prev[i] = cost[0][i];
        }

        for (int i = 1; i < n; i++) {
            curr = new int[3];
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                curr[j] = cost[i][j];
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    min = Math.min(min, prev[k]);
                }
                curr[j] += min;
            }
            prev = Arrays.copyOf(curr, curr.length);
        }

        int answer = Arrays.stream(curr)
            .min()
            .getAsInt();

        System.out.println(answer);
    }
}